<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>

<netui:html>
    <head>
        <netui:base/>
    </head>
    <netui:body>
       <h3>Log in to Jarden Banking</h3>

	<netui:form action="login">
		<div>
		<table>
			<tr valign="top">
				<td><label for="field1"> User name: </label></td>
				<td><netui:textBox dataSource="actionForm.fromName_arg" tagId="field1"></netui:textBox></td>
			</tr>
			<tr valign="top">
				<td><label for="field2"> Password: </label></td>
				<td><netui:textBox dataSource="actionForm.password_arg" password="true" tagId="field2"></netui:textBox></td>
			</tr>
		</table>
		</div>
		<netui:button value="login" type="submit" />
	</netui:form>
	<h3>${pageFlow.statusMessage }</h3>
</netui:body>
</netui:html>