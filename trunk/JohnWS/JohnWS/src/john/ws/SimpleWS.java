package john.ws;

import javax.jws.*;

import sun.misc.BASE64Encoder;

@WebService (targetNamespace="http://john")
public class SimpleWS {

	
	@WebMethod(operationName="john-Get-PDF")
	@WebResult(name="John-String-Result",
            targetNamespace="http://jarden.com/")
	public String getB2BQuotePDF(@WebParam(name="John-String-Input",
            targetNamespace="http://jarden.com/string") String arg0,
            @WebParam(name="header-param", header=false) String arg1) {
		String message = "SimpleWS.getB2BQuotePDF('" + arg0 + ", " + arg1 + "')";
		System.out.println(message);
		BASE64Encoder base64Encoder = new BASE64Encoder(); 
		return base64Encoder.encode(arg0.getBytes());
	}
}