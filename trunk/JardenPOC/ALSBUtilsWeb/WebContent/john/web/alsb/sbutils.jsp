<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<netui-data:declarePageInput required="false" type="john.sbconfig.EsbQueryResult[]" name="esbQueryResult" />

<netui:html>
    <head>
        <netui:base/>
    </head>
    <netui:body>
       <h3>ALSB Services</h3>

	<netui:form action="getSBEndpoints">
		<div>
		<table>
			<tr valign="top">
				<td><label for="field0"> ALSB name: </label></td>
				<td><netui:select dataSource="actionForm.alsbName" optionsDataSource="${pageFlow.alsbNames}" tagId="field0"/></td>
			</tr>
			<tr valign="top">
				<td><label for="field4"> Action: </label></td>
				<td><netui:select nullable="true" dataSource="actionForm.action" optionsDataSource="${pageFlow.resourceTypes}" tagId="field4"/></td>
			</tr>
		</table>
		</div>
		<netui:button value="getSBEndpoints" type="submit" />
		<netui:button value="getInvalidSBEndpoints" action="getInvalidSBEndpoints" />
	</netui:form>
	<netui-data:repeater dataSource="pageInput.esbQueryResult">
		<netui-data:repeaterHeader>
			<table class="tablebody" border="1">
				<tr class="tablehead" valign="top">
					<th scope="col">Name</th>
					<th scope="col">Value</th>
				</tr>
				</netui-data:repeaterHeader>
				<netui-data:repeaterItem>
					<tr valign="top">
						<td><netui:span value="${container.item.name}" defaultValue="&nbsp;" /></td>
						<td><netui:span value="${container.item.value}" defaultValue="&nbsp;" /></td>
					</tr>
					<p />
				</netui-data:repeaterItem>
				<netui-data:repeaterFooter>
			</table>
			</netui-data:repeaterFooter>
	</netui-data:repeater>
	<h3>${pageFlow.controllerStatus}</h3>
</netui:body>
</netui:html>