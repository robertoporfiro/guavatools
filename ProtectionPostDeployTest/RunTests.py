import testdefinitions
import validatordefinitions

from java.util import ArrayList
from java.util import Date
from java.io import File

from junit.framework import TestSuite
from junit.framework import TestResult
from com.zurich.ep.protection.alsb.test import XMLObjectTest
from com.zurich.ep.protection.alsb.test import ALSBTestCase
from com.zurich.ep.protection.alsb.test import PerfTestResultsAggregator
  
tests=testdefinitions.tests
validators=validatordefinitions.validators

def runTests():
    print "Configuring tests"
#   propsFile = File("ALSBTest.properties")
#   props=getProps(propsFile)
#    print "Running tests agains this URL: " , props.get("alsb.url")
    testsCreated=0
    testSuite = TestSuite()
    aggregator= PerfTestResultsAggregator("c:/temp/ALSBTestErrors/perf.csv");
    aggregator.initialize()
    for test in tests :
        validatorList = ArrayList()
        for v in test[3]:
            validatorList.add(validators[v])
        testsCreated = testsCreated +1
        testCase = ALSBTestCase(test[0],test[1], test[2], validatorList,testsCreated);
        testCase.setAggregator(aggregator)
        testSuite.addTest(testCase)
        
    
    print testsCreated, ' tests were configured to run'
    
    testResult = TestResult()
    print 'running test suite'
    print 'test cases: ',  testSuite.countTestCases()
    startTime = Date();
    testSuite.run(testResult)
    aggregator.dispose()
    endTime = Date();
    seconds = (endTime.getTime()/1000) - (startTime.getTime() / 1000);
    averageInvTime = seconds / testSuite.countTestCases();
    minutes = seconds / 60
    seconds = seconds % 60
    
    print 'test suite run in ', minutes,':',seconds, '(',averageInvTime,' secs / test)'
    if testResult.wasSuccessful() :
        print '#########################        OKAY! :-)        ############################\n'
        print testResult.runCount(), 'tests were run'
        
    else:
        print '#########################        FAIL! :-(        ############################\n'
        print 'failures (',testResult.failureCount(),')'
        print '___________________________________________\n'
        for failure in testResult.failures():
            print failure
        print '\nerrors (',testResult.errorCount(),')'
        print '___________________________________________\n'
        for error in testResult.errors():
            print error



def loadProps(configPropFile):
    propInputStream = FileInputStream(configPropFile)
    configProps = Properties()
    configProps.load(propInputStream)
    return configProps

    
runTests()

