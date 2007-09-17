<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-html-1.0" prefix="netui"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-databinding-1.0" prefix="netui-data"%>
<%@taglib uri="http://beehive.apache.org/netui/tags-template-1.0" prefix="netui-template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<netui-data:declarePageInput name="confirmOrderResult" type="jarden.shop.Invoice" required="true"/>

<netui:html>
    <head>
        <netui:base/>
    </head>
    <netui:body>
    <h3>Checkout complete</h3>
	<fmt:formatNumber currencySymbol="£"
		maxFractionDigits="2" minFractionDigits="2">
		${pageFlow.cart.totalPrice}
	</fmt:formatNumber>
     has been debited from account ${pageFlow.cart.accountName} - thank you!<br>
    The following items will not be delivered to your desk:<br/>
	<netui-data:repeater dataSource="pageFlow.cart.items">
		<netui-data:repeaterHeader>
			<table class="tablebody" border="1">
				<tr class="tablehead" valign="top">
					<th scope="col">Supplier</th>
					<th scope="col">Code</th>
					<th scope="col">Name</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
				</tr>
				</netui-data:repeaterHeader>
				<netui-data:repeaterItem>
					<tr valign="top">
						<td><netui:span value="${container.item.supplier}" defaultValue="&nbsp;" /></td>
						<td><netui:span value="${container.item.code}" defaultValue="&nbsp;" /></td>
						<td><netui:span value="${container.item.name}" defaultValue="&nbsp;" /></td>
						<td><netui:span value="${container.item.quantity}" defaultValue="&nbsp;" /></td>
						<td><fmt:formatNumber currencySymbol="£"
								maxFractionDigits="2" minFractionDigits="2">
								${container.item.price}
							</fmt:formatNumber>
						</td>
					</tr>
					<p />
				</netui-data:repeaterItem>
				<netui-data:repeaterFooter>
			</table>
			</netui-data:repeaterFooter>
	</netui-data:repeater>

	<netui:anchor action="home">Home</netui:anchor>
</netui:body>
</netui:html>