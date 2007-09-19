package john.ws.cart;

import java.io.Serializable;

import javax.jws.*;

import john.db.ProductVO;

import weblogic.jws.Context;
import weblogic.jws.Conversation;
import weblogic.jws.Conversational;
import weblogic.wsee.jws.JwsContext;
import org.apache.beehive.controls.api.bean.Control;

@WebService
@Conversational(maxAge = "20 minutes", maxIdleTime = "10 minutes")
/*
 * Conversational version of Shop2WS.
 */
public class ShopWS implements Serializable
{
	private static final String myShopAccountName = "john";
	private static final long serialVersionUID = 1L;

	private Invoice invoice;
	@Context
	private JwsContext jwsContext;
	@Control
	private ProductWSServiceControl productWSServiceControl;
	@Control
	private BankWSServiceControl bankWSServiceControl;

	@Conversation (Conversation.Phase.START)
	public void newCart(String client) {
		invoice = new Invoice();
		invoice.setClient(client);
	}
	public ProductVO[] getAllProducts() {
		return productWSServiceControl.getAllProducts();
	}
	@Conversation (Conversation.Phase.CONTINUE)
	public void addItem(String supplier, String code, int qty) {
		ProductVO product = productWSServiceControl.getProduct(supplier, code);
		double price = product.getPrice() * qty;
		CartItem item = new CartItem(supplier, code, product.getName(), qty, price);
		invoice.addItem(item);
	}
	@Conversation (Conversation.Phase.CONTINUE)
	public String getClient() {
		return invoice.getClient();
	}
	@Conversation (Conversation.Phase.CONTINUE)
	public Invoice getCart() {
		return invoice;
	}
	@Conversation (Conversation.Phase.FINISH)
	public Invoice placeOrder(String accountName, String accountPassword) {
		invoice.setAccountName(accountName);
		bankWSServiceControl.transfer(accountName, accountPassword, myShopAccountName,
				invoice.getTotalPrice());
		return invoice;
	}
	/*
	private void printHeaders() {
		Element[] inputHeaders = jwsContext.getInputHeaders();
		for (Element element: inputHeaders) {
			try {
				XmlObject obj = XmlObject.Factory.parse(element.getDocumentElement());
				System.out.println(obj);
			} catch (XmlException e) {
				e.printStackTrace();
			}
			
		}
	}
	*/
	
}