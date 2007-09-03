<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>

<netui:html>
    <head>
        <netui:base/>
    </head>
    <netui:body>
       <h2>Service Catalog</h2>
       
	<h3>Current Package</h3>
	<netui-data:repeater dataSource="pageFlow.currentPackageHierarchy">
		<netui-data:repeaterHeader/>
		<netui-data:repeaterItem>
			<netui:anchor action="selectPackage" >
				<netui:parameter value="${container.item.name}" name="packageName"/>
				<netui:content value="${container.item.lastBit}" />
			</netui:anchor>.
		</netui-data:repeaterItem>
		<netui-data:repeaterFooter/>
	</netui-data:repeater>
	<h3>Sub packages</h3>
	<netui-data:repeater dataSource="pageFlow.currentMemberPackages">
		<netui-data:repeaterHeader><ul>
		</netui-data:repeaterHeader>
		<netui-data:repeaterItem>
			<li>
				<netui:anchor action="selectPackage" >
					<netui:parameter value="${container.item.name}" name="packageName"/>
					<netui:content value="${container.item.lastBit}" />
				</netui:anchor>
			</li>
		</netui-data:repeaterItem>
		<netui-data:repeaterFooter></ul>
		</netui-data:repeaterFooter>
	</netui-data:repeater>
	<h3>Services in current package</h3>
	<netui-data:repeater dataSource="pageFlow.currentMemberServices">
		<netui-data:repeaterHeader>
			<table class="tablebody" border="1">
				<tr class="tablehead" valign="top">
					<th scope="col">Service</th>
					<!-- <th scope="col">WSDL</th> -->
				</tr>
				</netui-data:repeaterHeader>
				<netui-data:repeaterItem>
					<tr valign="top">
						<td>
							<netui:anchor action="selectService" >
								<netui:parameter value="${container.item.serviceName}" name="serviceName"/>
								<netui:content value="${container.item.serviceName}" />
							</netui:anchor>
						</td>
					</tr>
					<p />
				</netui-data:repeaterItem>
				<netui-data:repeaterFooter>
			</table>
			</netui-data:repeaterFooter>
	</netui-data:repeater><br/>
	<br/>
	<netui:anchor action="refreshServiceCatalog">Refresh Catalog</netui:anchor>
	<br>${pageFlow.controllerStatus}
</netui:body>
</netui:html>