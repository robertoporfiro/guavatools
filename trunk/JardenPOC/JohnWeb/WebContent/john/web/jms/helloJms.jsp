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
    <h2>Client for HelloJms Web Service</h2>
    Endpoint: ${pageFlow.helloEndpoint }
    <ul>
    	<li>jms://10.160.2.94:7041/JohnWS/HelloJmsWS?URI=jms.johnHelloQ [&FACTORY=javax.jms.QueueConnectionFactory]
    	</li>
    </ul>

	<netui:form action="hello">
		<table>
			<tr valign="top">
				<td><label for="field1"> Name: </label></td>
				<td><netui:textBox dataSource="actionForm.name_arg" tagId="field1"></netui:textBox></td>
			</tr>
		</table>
		<netui:button value="hello" type="submit" />
	</netui:form>
	<netui:span value="${pageInput.helloResult}"></netui:span>
	<netui:form action="setEndpointAddress1">
		<div>
		<table>
			<tr valign="top">
				<td><label for="field1"> Endpoint: </label></td>
				<td><netui:textBox dataSource="actionForm.p0" size="110"></netui:textBox></td>
			</tr>
		</table>
		</div>
		<netui:button value="Set Endpoint" type="submit" />
	</netui:form>
	<netui:anchor action="home">Home</netui:anchor>
</netui:body>
</netui:html>