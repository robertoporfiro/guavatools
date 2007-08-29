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
    <h2>John's client for Web Services, using jax-rpc rather than service controls</h2>
    Endpoint: ${pageFlow.endpoint}<br/>

	<netui:form action="hello">
		<table>
			<tr valign="top">
				<td><label for="field1"> Name: </label></td>
				<td><netui:textBox dataSource="actionForm.name" tagId="field1"></netui:textBox></td>
			</tr>
		</table>
		<netui:button value="hello" type="submit" />
	</netui:form>
	<netui:span value="${pageInput.helloResult}"></netui:span>
	<netui:form action="setEndpoint">
		<table>
			<tr valign="top">
				<td><label for="field1"> Endpoint: </label></td>
				<td><netui:textBox dataSource="actionForm.endpoint" tagId="field1"></netui:textBox></td>
			</tr>
		</table>
		<netui:button value="setEndpoint" type="submit" />
	</netui:form>
</netui:body>
</netui:html>