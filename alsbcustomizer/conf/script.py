from java.util import HashMap
from java.util import HashSet
from java.util import Collections
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

def customizeALSBDomain(importConfigFile, customFile):
    try:
        SessionMBean = None
        print 'Loading config from :', importConfigFile
        configProp = loadProps(importConfigFile)
        adminUrl = configProp.get("adminUrl")
        user = configProp.get("user")
        password = configProp.get("password")

        passphrase = configProp.get("passphrase")
        project = configProp.get("project")
	
        connectToServer(user, password, adminUrl)
        print 'connected to yer server'

        sessionName = createSessionName()
        print 'Created session', sessionName
        SessionMBean = getSessionMBean(sessionName)
        print 'SessionMBean started session'
        ALSBConfigurationMBean = findService(String("ALSBConfiguration.").concat(sessionName), "com.bea.wli.sb.management.configuration.ALSBConfigurationMBean")
        print "ALSBConfiguration MBean found", ALSBConfigurationMBean
        
	#customize if a customization file is specified
	#affects only the created resources
	if customFile != None :
		print 'Loading customization File', customFile

		iStream = FileInputStream(customFile)
		customizationList = Customization.fromXML(iStream)

		for customization in customizationList:
			print '\n customization', customization.getDescription()

		print customizationList.size()
		ALSBConfigurationMBean.customize(customizationList)
		print 'Customization applied'
		SessionMBean.commitSession(sessionName)
		print 'session committed'
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
# Utility function to load properties from a config file
#=======================================================================================

def loadProps(configPropFile):
    propInputStream = FileInputStream(configPropFile)
    configProps = Properties()
    configProps.load(propInputStream)
    return configProps

#=======================================================================================
# Connect to the Admin Server
#=======================================================================================

def connectToServer(username, password, url):
    connect(username, password, url)
    domainRuntime()

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



# IMPORT script init
try:
    # argv[1] is the export config properties file
    customizeALSBDomain(sys.argv[1], sys.argv[2])

except:
    print "Unexpected error: ", sys.exc_info()[0]
    dumpStack()
    raise