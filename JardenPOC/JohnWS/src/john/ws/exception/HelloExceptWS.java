package john.ws.exception;

import javax.jws.*;
import javax.xml.rpc.soap.SOAPFaultException;
import javax.xml.soap.Detail;
import javax.xml.soap.DetailEntry;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;

/**
 * Web service to show 2 ways of generating a soap exception.
 * Method hello() declares that it throws a checked exception (CaseException);
 * the server stub converts this into a SOAP Fault, and the client stub turns it
 * back into a java exception, which may be caught by the client code. The
 * exception appears in the WSDL, and the service control generated from this
 * WSDL will declare a checked exception on this method.
 * Method goodbye() hand builds and throws a SOAPFaultException, which is exactly
 * the same XML passed to the client as method hello(). This method does not declare
 * any exception, and hence no exception is declared on the goodbye method of the
 * generated service control (hence the client is not forced to handle the exception.
 * @author John Denny.
 *
 */
@WebService
public class HelloExceptWS {
	
	static {
		// this bit should be done outside the program
		System.setProperty("javax.xml.soap.SOAPFactory", "weblogic.xml.saaj.SOAPFactoryImpl");
	}
	public String hello(String name) throws CaseException {
		String action = "HelloExceptWS.hello('" + name + "')";
		System.out.println(action);
		if (!Character.isUpperCase(name.charAt(0))) {
			throw new CaseException(name + " must start with upper case letter");
		}
		return action;
	}
	public String goodbye(String name) {
		String action = "HelloExceptWS.goodbye('" + name + "')";
		System.out.println(action);
		if (!Character.isUpperCase(name.charAt(0))) {
			createAndThrowSOAPFault(name + " must start with upper case letter");
		}
		return action;
	}
	private void createAndThrowSOAPFault(String message) {
	    Detail detail = null;
	    try {
			SOAPFactory soapFactory = SOAPFactory.newInstance();
			detail = soapFactory.createDetail();
			Name name1 = soapFactory.createName("CaseException", "java", "java:john.ws.exception");
			DetailEntry entry = detail.addDetailEntry(name1);
			SOAPElement child = entry.addChildElement("Message", "java", "java:john.ws.exception");
			child.setValue(message);
	    } catch (SOAPException e) {
	    	e.printStackTrace();
	    }
        throw new SOAPFaultException(null, message, 
        	null, // Don't use fault actors
            detail);
	}
}