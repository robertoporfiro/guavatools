<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<netui-data:declarePageInput required="false" type="java.lang.String" name="helloResult" />

<netui:html>
    <head>
        <netui:base/>
    </head>
    <netui:body>
       <h3>Client for JohnWS</h3>
	   <netui:anchor action="login">Login</netui:anchor>
       Username: ${pageFlow.username}<br/>

	<netui:form action="hello">
		<div>
		<table>
			<tr valign="top">
				<td><label for="field1"> Name: </label></td>
				<td><netui:textBox dataSource="actionForm.name_arg" size="35" tagId="field1"></netui:textBox></td>
			</tr>
		</table>
		</div>
		<netui:button value="Hello" type="submit" />
		<netui:button action="samlHello" value="SAML Hello" />
		<netui:button action="secretHello" value="Secret Hello" />
		<netui:button action="authHello" value="Auth Hello" />
		<netui:button action="signHello" value="Sign Hello" />
		<netui:anchor action="setMessage">Set Message</netui:anchor>
	</netui:form>

	<netui:span value="${pageInput.helloResult}"></netui:span>
	<netui:form action="logMessage">
		<div>
		<table>
			<tr valign="top">
				<td><label for="field1"> Message: </label></td>
				<td><netui:textBox dataSource="actionForm.message_arg" tagId="field1"></netui:textBox></td>
			</tr>
			<tr valign="top">
				<td><label for="field2"> Rollback: </label></td>
				<td><netui:checkBox dataSource="actionForm.rollback"/></td>
			</tr>
		</table>
		</div>
		<netui:button value="logMessage" type="submit" />
	</netui:form>
	<netui:form action="setEndpoint">
		Hello Endpoint: <netui:select dataSource="actionForm.endpointName" tagId="field1"
			optionsDataSource="${pageFlow.endpointNames}"/>
		<netui:button value="setEndpoint" type="submit" />
	</netui:form>

	<netui:form action="setEndpointAddress2">
		Hello Endpoint: <netui:textBox dataSource="actionForm.p0" tagId="field1" size="35"/>
		<netui:button value="setEndpoint" type="submit" />
	</netui:form>

	HelloWS endpoint address: ${pageFlow.helloEndpointAddress}
</netui:body>
</netui:html>