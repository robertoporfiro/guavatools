<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<netui:html>
    <head>
        <netui:base/>
    </head>
    <netui:body>
    <h2>Model Services: ${pageFlow.currentService.serviceName}</h2>
	<netui-data:repeater dataSource="pageFlow.currentService.endpoints">
		<netui-data:repeaterHeader>
			<table class="tablebody" border="1">
				<tr class="tablehead" valign="top">
					<th scope="col"></th>
					<th scope="col">Endpoint</th>
				</tr>
				</netui-data:repeaterHeader>
				<netui-data:repeaterItem>
					<tr valign="top">
						<td><netui:span value="${container.item.name}" defaultValue="&nbsp;" /></td>
						<td>
							<c:if test="${container.item.hyperlink}">
								<netui:anchor href="${container.item.value}">${container.item.value}</netui:anchor>
							</c:if>
							<c:if test="${container.item.hyperlink == false}">
								<netui:span value="${container.item.value}" defaultValue="&nbsp;" />
							</c:if>
						</td>
					</tr>
					<p />
				</netui-data:repeaterItem>
				<netui-data:repeaterFooter>
			</table>
			</netui-data:repeaterFooter>
	</netui-data:repeater>
	<br/>
	<br/>
	<netui:anchor action="home">Back</netui:anchor>
	${pageFlow.controllerStatus}
    
    </netui:body>
</netui:html>