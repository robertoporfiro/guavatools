from java.util import HashMap
from java.util import HashSet
from java.util import ArrayList
from java.io import FileInputStream

from com.bea.wli.config import TypeIds
from com.bea.wli.config.customization import Customization
from com.bea.wli.sb.management.importexport import ALSBImportOperation

import sys


#=======================================================================================
# Entry function to deploy project configuration and resources
#        into a ALSB domain
#=======================================================================================

def importToALSBDomain(importConfigFile,genConfig):
    try:
        SessionMBean = None
        print 'Loading Deployment config from :', importConfigFile
        exportConfigProp = loadProps(importConfigFile,genConfig)
        adminUrl = exportConfigProp.get("adminUrl")
        importUser = exportConfigProp.get("user")
        importPassword = exportConfigProp.get("password")

        importJar = exportConfigProp.get("jarFileName")
        customFile = exportConfigProp.get("customizationFile")

        passphrase = exportConfigProp.get("passphrase")
        project = exportConfigProp.get("project")

        connectToServer(importUser, importPassword, adminUrl)

        print 'Attempting to import :', importJar, "on ALSB Admin Server listening on :", adminUrl

        theBytes = readBinaryFile(importJar)
        print 'Read file', importJar
        sessionName = createSessionName()
        print 'Created session', sessionName
        SessionMBean = getSessionMBean(sessionName)
        print 'SessionMBean started session'
        ALSBConfigurationMBean = findService(String("ALSBConfiguration.").concat(sessionName), "com.bea.wli.sb.management.configuration.ALSBConfigurationMBean")
        print "ALSBConfiguration MBean found", ALSBConfigurationMBean
        ALSBConfigurationMBean.uploadJarFile(theBytes)
        print 'Jar Uploaded'

        if project == None:
            print 'No project specified, additive deployment performed'
            importResult = ALSBConfigurationMBean.importUploaded(None, false, true, passphrase)
            SessionMBean.commitSession(sessionName)
        else:
            print 'ALSB project', project, 'will get overlaid'
            alsbJarInfo = ALSBConfigurationMBean.getImportJarInfo()
            alsbImportPlan = alsbJarInfo.getDefaultImportPlan()
            alsbImportPlan.setPassphrase(passphrase)
            operationMap=HashMap()
            operationMap = alsbImportPlan.getOperations()
            print
            print 'Default importPlan'
            printOpMap(operationMap)
            set = operationMap.entrySet()

            alsbImportPlan.setPreserveExistingEnvValues(true)

            #boolean
            abort = false
            #list of created ref
            createdRef = ArrayList()

            for entry in set:
                ref = entry.getKey()
                op = entry.getValue()
                #set different logic based on the resource type
                type = ref.getTypeId
                if type == TypeIds.SERVICE_ACCOUNT_REF or type == TypeIds.SERVICE_PROVIDER_REF:
                    if op.getOperation() == ALSBImportOperation.Operation.Create:
                        print 'Unable to import a service account or a service provider on a target system', ref
                        abort = true
                elif op.getOperation() == ALSBImportOperation.Operation.Create:
                    #keep the list of created resources
                    createdRef.add(ref)

            if abort == true :
                print 'This jar must be imported manually to resolve the service account and service provider dependencies'
                SessionMBean.discardSession(sessionName)
                raise

            print
            print 'Modified importPlan'
            printOpMap(operationMap)
            importResult = ALSBConfigurationMBean.importUploaded(alsbImportPlan)

            printDiagMap(importResult.getImportDiagnostics())

            if importResult.getFailed().isEmpty() == false:
                print 'One or more resources could not be imported properly'
                raise

            #customize if a customization file is specified
            #affects only the created resources
            if customFile != None :
                print 'Loading customization File', customFile
                print 'Customization applied to the created resources only', createdRef
                iStream = FileInputStream(customFile)
                customizationList = Customization.fromXML(iStream)
                filteredCustomizationList = ArrayList()
                setRef = HashSet(createdRef)

                # apply a filter to all the customizations to narrow the target to the created resources
                for customization in customizationList:
                    print customization
                    newcustomization = customization.clone(setRef)
                    filteredCustomizationList.add(newcustomization)

                ALSBConfigurationMBean.customize(filteredCustomizationList)

            SessionMBean.commitSession(sessionName)

        print "Deployment of : " + importJar + " successful"
    except:
        print "Unexpected error:", sys.exc_info()[0]
        if SessionMBean != None:
            SessionMBean.discardSession(sessionName)
        raise

#=======================================================================================
# Utility function to print the list of operations
#=======================================================================================
def printOpMap(map):
    set = map.entrySet()
    for entry in set:
        op = entry.getValue()
        print op.getOperation(),
        ref = entry.getKey()
        print ref
    print

#=======================================================================================
# Utility function to print the diagnostics
#=======================================================================================
def printDiagMap(map):
    set = map.entrySet()
    for entry in set:
        diag = entry.getValue().toString()
        print diag
    print


#=======================================================================================
# Utility function to read a binary file
#=======================================================================================
def readBinaryFile(fileName):
    file = open(fileName, 'rb')
    bytes = file.read()
    return bytes

#=======================================================================================
# Utility function to create an arbitrary session name
#=======================================================================================
def createSessionName():
    sessionName = String("SessionScript"+Long(System.currentTimeMillis()).toString())
    return sessionName

#=======================================================================================
# Utility function to load a session MBeans
#=======================================================================================
def getSessionMBean(sessionName):
    SessionMBean = findService("Session","com.bea.wli.config.mbeans.SessionMBean")
    SessionMBean.createSession(sessionName)
    return SessionMBean

       
#=======================================================================================
# Utility function to load properties from a config file
#=======================================================================================

def loadProps(configPropFile, generalPropFile):
    genFile = File(generalPropFile)
    confFile = File(configPropFile)
    propInputStream = FileInputStream(configPropFile)
    genPropInputStream = FileInputStream(generalPropFile)
    configProps = Properties()
    configProps.load(propInputStream)
    configProps.load(genPropInputStream)
    return configProps

#=======================================================================================
# Connect to the Admin Server
#=======================================================================================

def connectToServer(username, password, url):
    connect(username, password, url)
    domainRuntime()


# IMPORT script init
try:
    # import the service bus configuration
    # argv[1] is the export config properties file
    importToALSBDomain(sys.argv[1],sys.argv[2])

except:
    print "Unexpected error: ", sys.exc_info()[0]
    dumpStack()
    raise