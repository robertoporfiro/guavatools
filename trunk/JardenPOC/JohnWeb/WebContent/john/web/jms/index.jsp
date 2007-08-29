<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>

<netui:html>
    <head>
        <netui:base/>
    </head>
    <netui:body>
    <h2>Client for LogMessageJmsWS</h2>
    Endpoint: ${pageFlow.endpoint}<br/>
    <ul>
    	<li>jms://10.160.2.94:7041/JohnWS/LogMessageJmsPersistWS?URI=jms.johnDBQ&FACTORY=javax.jms.QueueConnectionFactory</li>
		<li>jms://10.160.2.94:7041/JohnWS/LogMessageJmsWS?URI=jms.johnNonPersistQ2&FACTORY=javax.jms.QueueConnectionFactory</li>
    </ul>

	<netui:form action="logMessage">
		<table>
			<tr valign="top">
				<td><label for="field1"> Message: </label></td>
				<td><netui:textBox dataSource="actionForm.message_arg" tagId="field1"></netui:textBox></td>
			</tr>
		</table>
		<netui:button value="logMessage" type="submit" />
	</netui:form>
	<netui:form action="setEndpointAddress">
		<table>
			<tr valign="top">
				<td><label for="field1"> Endpoint: </label></td>
				<td><netui:textBox size="100" dataSource="actionForm.p0" tagId="field1"></netui:textBox></td>
			</tr>
		</table>
		<netui:button value="Set Endpoint" type="submit" />
	</netui:form>
<netui:anchor action="goToHelloJms">Call goToHelloJms</netui:anchor>
</netui:body>
</netui:html>