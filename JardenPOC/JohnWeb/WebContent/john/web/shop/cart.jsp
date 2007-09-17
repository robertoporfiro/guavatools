<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<netui-data:declarePageInput required="false" type="java.lang.String" name="setAccountResult" />

<netui:html>
    <head>
        <netui:base/>
    </head>
    <netui:body>
    <h2>John's Shopping Cart</h2>
    <table>
    	<tr>
    		<td bgcolor="#E0E0FF">
				<netui:form action="addItem">
					<div>
					<table>
						<tr valign="top">
							<td><label for="field0"> Supplier Name: </label></td>
							<td><netui:textBox dataSource="actionForm.supplier_arg" tagId="field0"></netui:textBox></td>
						</tr>
						<tr valign="top">
							<td><label for="field1"> Product Code: </label></td>
							<td><netui:textBox dataSource="actionForm.code_arg" tagId="field1"></netui:textBox></td>
						</tr>
						<tr valign="top">
							<td><label for="field2"> Quantity: </label></td>
							<td><netui:textBox dataSource="actionForm.qty_arg" tagId="field2"></netui:textBox></td>
						</tr>
					</table>
					</div>
					<netui:button value="Add Item" type="submit" />
				</netui:form>
				<netui:form action="setAccount">
					<div>
					<table>
						<tr valign="top">
							<td><label for="field0"> Account Name: </label></td>
							<td><netui:textBox dataSource="actionForm.accountName_arg" tagId="field0"></netui:textBox></td>
						</tr>
						<tr valign="top">
							<td><label for="field1"> Account Password: </label></td>
							<td><netui:textBox password="true" dataSource="actionForm.accountPassword_arg" tagId="field1"/></td>
						</tr>
					</table>
					</div>
					<netui:button value="Set Account" type="submit" />
				</netui:form>
				<netui:span value="${pageInput.setAccountResult}"></netui:span>
    		</td>
    		<td bgcolor="#E0FFE0">
				<table>
					<tr valign="top">
						<td>Client:</td>
						<td><netui:span value="${pageFlow.cart.client}" defaultValue="&nbsp;" /></td>
					</tr>
					<tr valign="top">
						<td>AccountName:</td>
						<td><netui:span value="${pageFlow.cart.accountName}" defaultValue="&nbsp;" /></td>
					</tr>
					<tr valign="top">
						<td>Items:</td>
						<td><netui-data:repeater dataSource="pageFlow.cart.items">
							<netui-data:repeaterHeader>
								<table class="tablebody" border="1">
									<tr class="tablehead" valign="top">
										<th scope="col">Code</th>
										<th scope="col">Supplier</th>
										<th scope="col">Price</th>
										<th scope="col">Qty</th>
										<th scope="col">Name</th>
									</tr>
									</netui-data:repeaterHeader>
									<netui-data:repeaterItem>
										<tr valign="top">
											<td><netui:span value="${container.item.code}" defaultValue="&nbsp;" /></td>
											<td><netui:span value="${container.item.supplier}" defaultValue="&nbsp;" /></td>
											<td><fmt:formatNumber currencySymbol="£" maxFractionDigits="2" minFractionDigits="2">
													${container.item.price}
												</fmt:formatNumber>
											</td>
											<td><netui:span value="${container.item.quantity}" defaultValue="&nbsp;" /></td>
											<td><netui:span value="${container.item.name}" defaultValue="&nbsp;" /></td>
										</tr>
										<p />
									</netui-data:repeaterItem>
									<netui-data:repeaterFooter>
								</table>
								</netui-data:repeaterFooter>
						</netui-data:repeater></td>
					</tr>
					<tr valign="top">
						<td>TotalPrice:</td>
						<td><fmt:formatNumber currencySymbol="£" maxFractionDigits="2" minFractionDigits="2">
							${pageFlow.cart.totalPrice}
						</fmt:formatNumber></td>
					</tr>
				</table>
				<c:if test="${pageFlow.accountValid}">
					<netui:anchor action="cancelOrder">Cancel Order</netui:anchor>
					<netui:anchor action="confirmOrder">Complete Order</netui:anchor>
				</c:if>
    		</td>
    	</tr>
    </table>

	<netui-data:repeater dataSource="pageFlow.allProducts">
		<netui-data:repeaterHeader>
			<table class="tablebody" border="1">
				<tr class="tablehead" valign="top">
					<th scope="col">Supplier</th>
					<th scope="col">Code</th>
					<th scope="col">Name</th>
					<th scope="col">Price</th>
				</tr>
				</netui-data:repeaterHeader>
				<netui-data:repeaterItem>
					<tr valign="top">
						<td><netui:span value="${container.item.supplier}" defaultValue="&nbsp;" /></td>
						<td><netui:span value="${container.item.code}" defaultValue="&nbsp;" /></td>
						<td><netui:anchor action="selectProduct">${container.item.name}
							<netui:parameter name="supplier" value="${container.item.supplier}" />
							<netui:parameter name="code" value="${container.item.code}" />
						</netui:anchor></td>
						<td><netui:span value="${container.item.price}" defaultValue="&nbsp;" /></td>
					</tr>
					<p />
				</netui-data:repeaterItem>
				<netui-data:repeaterFooter>
			</table>
			</netui-data:repeaterFooter>
	</netui-data:repeater>
</netui:body>
</netui:html>