<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<netui-data:declarePageInput required="false" type="java.lang.String" name="cancelOrderResult" />


<netui:html>
    <head>
        <netui:base/>
    </head>
    <netui:body>
    <h2>John's Shopping Client</h2>

	<netui:form action="newCart">
		<div>
		<table>
			<tr valign="top">
				<td><label for="field1"> Client Name: </label></td>
				<td><netui:textBox dataSource="actionForm.client_arg" tagId="field1"></netui:textBox></td>
			</tr>
		</table>
		</div>
		<netui:button value="New Cart" type="submit" />
	</netui:form>
	<netui:form action="setEndpointAddress">
		<div>
		<table>
			<tr valign="top">
				<td><label for="field1"> Web Service (proxy) Endpoint: </label></td>
				<td><netui:textBox size="50" dataSource="actionForm.p0" tagId="field1"></netui:textBox></td>
			</tr>
		</table>
		</div>
		<netui:button value="Set Endpoint" type="submit" />
	</netui:form>
	Current Endpoint: ${pageFlow.endpoint}<br/>
	<netui:span value="${pageInput.cancelOrderResult}"></netui:span>
</netui:body>
</netui:html>