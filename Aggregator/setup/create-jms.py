targetServerName='AdminServer'
fileStorePath='jmsFileStores/lch-shared'

# all of the below properties remain the same between environments


fileStoreName='OSB.FileStore'
JMSServerName='OSB.JMSServer'
moduleName='OSB.JMSModule'
######### QUEUES AND CONNECTION FACTORIES ARE DEFINED AT THE BOTTOM OF THE SCRIPT

subDeploymentName='OSB.SingleServerSubdeployment'

templateName='OSB_JMS_TEMPLATE'
redeliveryLimit=0	# messages should not be redelivered in this implementation
redeliveryDelay=0

errorQueueName='jms/OSB.System.Dead.Letter.Queue'



def addDestinationKeyToQueue(queueName,keyName,direction, type, propertyName):
	cd('/JMSSystemResources/'+moduleName+'/JMSResource/'+moduleName)
	cmo.createDestinationKey(keyName)
	cd('/JMSSystemResources/'+moduleName+'/JMSResource/'+moduleName+'/DestinationKeys/'+keyName)
	cmo.setSortOrder(direction)
	cmo.setProperty('User-Defined')
	cmo.setKeyType(type)
	cmo.setProperty(propertyName)


	cd('/JMSSystemResources/'+moduleName+'/JMSResource/'+moduleName)
	cd('/JMSSystemResources/'+moduleName+'/JMSResource/'+moduleName+'/Queues/'+queueName)
	set('DestinationKeys',jarray.array([String(keyName)], String))




def createQueue(moduleName, queueName, subdeploymentName, templateName):
	cd('/JMSSystemResources/'+moduleName+'/JMSResource/'+moduleName)
	cmo.createQueue(queueName)
	cd('/JMSSystemResources/'+moduleName+'/JMSResource/'+moduleName+'/Queues/'+queueName)
	cmo.setJNDIName(queueName)
	cmo.setSubDeploymentName(subdeploymentName)
	if(templateName != None):
		cmo.setTemplate(getMBean('/JMSSystemResources/'+moduleName+'/JMSResource/'+moduleName+'/Templates/'+templateName))
	else:
		print 'not setting template since none was provided'
		() # ignore
		

def createJMSServer(JMSServerName, fileStoreName,targetServerName):
	cd('/')
	cmo.createJMSServer(JMSServerName)
	cd('/Deployments/'+JMSServerName)
	cmo.setPersistentStore(getMBean('/FileStores/'+fileStoreName))
	set('Targets',jarray.array([ObjectName('com.bea:Name='+targetServerName+',Type=Server')], ObjectName))
	print 'JMSServer created: '+JMSServerName


def destroyJMSServer(JMSServerName):
	cd('/')
	print 'attempting to destroy exisiting server'
	try:
		cmo.destroyJMSServer(getMBean('/Deployments/'+JMSServerName))
		print 'server '+JMSServerName+' destroyed'
	except:
		print 'destroy failed. This could be due to the server not already existing'


def destroyFileStore(fileStoreName):
	cd('/')
	print 'attempting to destroy exisiting fileStore'
	cmo.destroyFileStore(getMBean('/FileStores/'+fileStoreName))
	try:
		cmo.destroyFileStore(getMBean('/FileStores/'+fileStoreName))
		print 'fileStore destroyed'
	except:
		print 'destroy failed. This could be due to the module not already existing'
			

def createFileStore(fileStoreName, fileStoreDirectory, targetServerName):
	cd('/')
	cmo.createFileStore(fileStoreName)
	cd('/FileStores/'+fileStoreName)
	cmo.setDirectory(fileStoreDirectory)
	set('Targets',jarray.array([ObjectName('com.bea:Name='+targetServerName+',Type=Server')], ObjectName))
	print 'FileStore created: '+fileStoreName


def destroyModule(moduleName):
	cd('/')
	print 'attempting to destroy exisiting module'
	try:
		cmo.destroyJMSSystemResource(getMBean('/SystemResources/'+moduleName))
		print 'module destroyed'
	except:
		print 'destroy failed. This could be due to the module not already existing'



def createModuleAndSubDeployment(moduleName, subDeploymentName, jmsServerName, targetServerName):
	cd('/')
	cmo.createJMSSystemResource(moduleName)
	cd('/SystemResources/'+moduleName)
	set('Targets',jarray.array([ObjectName('com.bea:Name='+targetServerName+',Type=Server')], ObjectName))
	cmo.createSubDeployment(subDeploymentName)
	cd('/SystemResources/'+moduleName+'/SubDeployments/'+subDeploymentName)
	set('Targets',jarray.array([ObjectName('com.bea:Name='+jmsServerName+',Type=JMSServer')], ObjectName))
	print 'Module "'+moduleName+'" created with subdeployment: '+subDeploymentName


def createConnectionFactory(connectionFactoryName, moduleName):
	cd('/JMSSystemResources/'+moduleName+'/JMSResource/'+moduleName)
	cmo.createConnectionFactory(connectionFactoryName)
	cd('/JMSSystemResources/'+moduleName+'/JMSResource/'+moduleName+'/ConnectionFactories/'+connectionFactoryName)
	cmo.setJNDIName(connectionFactoryName)
	cd('/JMSSystemResources/'+moduleName+'/JMSResource/'+moduleName+'/ConnectionFactories/'+connectionFactoryName+'/SecurityParams/'+connectionFactoryName)
	cmo.setAttachJMSXUserId(false)
	cd('/JMSSystemResources/'+moduleName+'/JMSResource/'+moduleName+'/ConnectionFactories/'+connectionFactoryName)
	cmo.setDefaultTargetingEnabled(true)
	cd('/JMSSystemResources/'+moduleName+'/JMSResource/'+moduleName+'/ConnectionFactories/'+connectionFactoryName+'/DefaultDeliveryParams/'+connectionFactoryName)
	cmo.setDefaultDeliveryMode('Persistent')
	cmo.setDefaultPriority(4)
	cmo.setDefaultUnitOfOrder('None')
	cmo.setDefaultTimeToLive(0)
	cmo.setDefaultCompressionThreshold(2147483647)
	cmo.setSendTimeout(10)
	cmo.setDefaultRedeliveryDelay(3000)
	cmo.setDefaultTimeToDeliver('0')
	cmo.unSet('DefaultUnitOfOrder')



def createTemplate(templateName, moduleName, redeliveryLimit, redeliveryDelay, errorQueueName):
	cd('/JMSSystemResources/'+moduleName+'/JMSResource/'+moduleName)
	cmo.createTemplate(templateName)
	cd('/JMSSystemResources/'+moduleName+'/JMSResource/'+moduleName+'/Templates/'+templateName+'/DeliveryFailureParams/'+templateName)
	cmo.setRedeliveryLimit(redeliveryLimit)
	cmo.setExpirationPolicy('Redirect')
	cd('/JMSSystemResources/'+moduleName+'/JMSResource/'+moduleName+'/Templates/'+templateName+'/DeliveryParamsOverrides/'+templateName)
	cmo.setRedeliveryDelay(redeliveryDelay)	
	cd('/JMSSystemResources/'+moduleName+'/JMSResource/'+moduleName+'/Templates/'+templateName+'/DeliveryFailureParams/'+templateName)
	cmo.setErrorDestination(getMBean('/JMSSystemResources/'+moduleName+'/JMSResource/'+moduleName+'/Queues/'+errorQueueName))



###################		Start here

edit()
startEdit()

destroyModule(moduleName)
destroyJMSServer(JMSServerName)
destroyFileStore(fileStoreName)

activate()
startEdit()
##################		JMS Server Stuff
createFileStore(fileStoreName, fileStorePath ,targetServerName)
createJMSServer(JMSServerName, fileStoreName,targetServerName)
createModuleAndSubDeployment(moduleName, subDeploymentName, JMSServerName,targetServerName)

##################		JMS Template Stuff

createQueue(moduleName, errorQueueName, subDeploymentName,None)
createTemplate(templateName, moduleName, redeliveryLimit, redeliveryDelay, errorQueueName)

##################		Destinations and Connection Factories

createConnectionFactory('OSB.jms.InboundConnectionFactory', moduleName)
createQueue(moduleName, 'jms/OSB.AggregatorSortQueue', subDeploymentName, templateName)
addDestinationKeyToQueue('jms/OSB.AggregatorSortQueue','BatchSortKey','Ascending','Int','noInBatch')
activate()
