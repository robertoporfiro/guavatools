package joe.ws.cart;

import java.io.Serializable;

import javax.jws.*;

import john.db.ProductVO;
import john.ws.bank.BankException;

import weblogic.jws.Context;
import weblogic.jws.Conversation;
import weblogic.jws.Conversational;
import weblogic.wsee.jws.JwsContext;
import org.apache.beehive.controls.api.bean.Control;

@WebService
@Conversational()
/*
 * Conversational version of Shop2WS.
 */
public class JoeShopWS implements Serializable
{
	private static final String myShopAccountName = "john";
	private static final long serialVersionUID = 1L;

	private Invoice invoice;
	private String accountPassword;
	@Context
	private JwsContext jwsContext;
	@Control
	private ProductWSServiceControl productWSServiceControl;
	@Control
	private BankWSServiceControl bankWSServiceControl;

	@Conversation (Conversation.Phase.START)
	public void newCart(String client) {
		String action = "JoeShopWS.newCart('" + client + "')";
		System.out.println(action);
		invoice = new Invoice();
		invoice.setClient(client);
	}
	public ProductVO[] getAllProducts() {
		String action = "JoeShopWS.getAllProducts()";
		System.out.println(action);
		return productWSServiceControl.getAllProducts();
	}
	@Conversation (Conversation.Phase.CONTINUE)
	public void addItem(String supplier, String code, int qty) {
		String action = "JoeShopWS.addItem('" + supplier + "', '" + code + "', " + qty + ")";
		System.out.println(action);
		ProductVO product = productWSServiceControl.getProduct(supplier, code);
		double price = product.getPrice() * qty;
		CartItem item = new CartItem(supplier, code, product.getName(), qty, price);
		invoice.addItem(item);
	}
	@Conversation (Conversation.Phase.CONTINUE)
	public String getClient() {
		String action = "JoeShopWS.getClient()";
		System.out.println(action);
		return invoice.getClient();
	}
	@Conversation (Conversation.Phase.CONTINUE)
	public Invoice getCart() {
		String action = "JoeShopWS.getCart()";
		System.out.println(action);
		return invoice;
	}
	@Conversation (Conversation.Phase.CONTINUE)
	public boolean setAccount(String accountName, String accountPassword) {
		String action = "JoeShopWS.setAccount('" + accountName + "', <accountPassword>)";
		System.out.println(action);
		invoice.setAccountName(accountName);
		this.accountPassword = accountPassword;
		try {
			double balance = bankWSServiceControl.getBalance(accountName, accountPassword);
			if (invoice.getTotalPrice() <= balance) {
				System.out.println("sufficient funds at the moment for cart " + invoice.getClient());
				return true;
			} else {
				System.out.println("insufficient funds at the moment for cart " + invoice.getClient());
				return false;
			}
		} catch (BankException e) {
			System.out.println(e);
			return false;
		}
	}
	@Conversation (Conversation.Phase.FINISH)
	public Invoice confirmOrder() throws BankException {
		String action = "JoeShopWS.confirmOrder()";
		System.out.println(action);
		bankWSServiceControl.transfer(invoice.getAccountName(), accountPassword,
				myShopAccountName, invoice.getTotalPrice());
		return invoice;
	}
	@Conversation (Conversation.Phase.FINISH)
	public String cancelOrder() {
		String action = "JoeShopWS.cancelOrder()";
		System.out.println(action);
		return "order cancelled";
	}
}