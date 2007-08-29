<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>

<netui:html>
    <head>
        <netui:base/>
    </head>
    <netui:body>
    	<h4>User ${pageFlow.userName} logged in. Balance: 
		<netui:span value="${pageFlow.balance}"></netui:span>
		<netui:anchor action="logout">Logout</netui:anchor></h4>

	<h3>Make payment</h3>
	<netui:form action="transfer">
		<table>
			<tr valign="top">
				<td><label for="field4"> To userName: </label></td>
				<td><netui:textBox dataSource="actionForm.toName_arg" tagId="field4"/></td>
			</tr>
			<tr valign="top">
				<td><label for="field2"> Amount: </label></td>
				<td><netui:textBox dataSource="actionForm.amount_arg" tagId="field2"/></td>
			</tr>
		</table>
		<netui:button value="transfer" type="submit" />
	</netui:form>
	<netui-data:repeater dataSource="pageFlow.transactionLog">
		<netui-data:repeaterHeader>
			<table class="tablebody" border="1">
				<tr class="tablehead" valign="top">
					<th scope="col">CreateTime</th>
					<th scope="col">Message</th>
				</tr>
				</netui-data:repeaterHeader>
				<netui-data:repeaterItem>
					<tr valign="top">
						<td><netui:label value="${container.item.createTime}" defaultValue="&nbsp;" >
								<netui:formatDate pattern="dd-MMM-yyyy HH:mm:ss"/>
							</netui:label>
						</td>
						<td><netui:span value="${container.item.message}" defaultValue="&nbsp;" /></td>
					</tr>
					<p />
				</netui-data:repeaterItem>
				<netui-data:repeaterFooter>
			</table>
			</netui-data:repeaterFooter>
	</netui-data:repeater>
	<netui:form action="changePassword">
		<div>
		<table>
			<tr valign="top">
				<td><label for="field1"> Current Password: </label></td>
				<td><netui:textBox dataSource="actionForm.oldPassword_arg" password="true"/></td>
			</tr>
			<tr valign="top">
				<td><label for="field1"> New Password: </label></td>
				<td><netui:textBox dataSource="actionForm.newPassword_arg" password="true"/></td>
			</tr>
		</table>
		</div>
		<netui:button value="Change Password" type="submit" />
	</netui:form>
	<h3>${pageFlow.statusMessage}</h3>
</netui:body>
</netui:html>