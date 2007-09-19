<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<netui-data:declarePageInput required="false" type="java.lang.Double" name="getBalanceResult" />

<netui:html>
    <head>
        <netui:base/>
    </head>
    <netui:body>
       <p>Beehive NetUI JavaServer Page - ${pageContext.request.requestURI}</p>

	<netui:form action="getBalance">
		<div>
		<table>
			<tr valign="top">
				<td><label for="field1"> UserName_arg: </label></td>
				<td><netui:textBox dataSource="actionForm.userName_arg" /></td>
			</tr>
			<tr valign="top">
				<td><label for="field2"> Password_arg: </label></td>
				<td><netui:textBox dataSource="actionForm.password_arg" password="true"/></td>
			</tr>
		</table>
		</div>
		<netui:button value="Get Balance" type="submit" />
	</netui:form>
	<netui:span value="${pageInput.getBalanceResult}"></netui:span>
</netui:body>
</netui:html>