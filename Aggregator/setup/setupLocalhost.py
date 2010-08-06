connect('weblogic','weblogic','t3://localhost:7001')

print 'Creating JMS Resources'
execfile('create-jms.py')
