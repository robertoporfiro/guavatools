package john.web.shop;

import jarden.shop.Invoice;
import jarden.shop.ProductVO;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.beehive.netui.pageflow.PageFlowController;
import org.apache.beehive.netui.pageflow.annotations.Jpf;
import org.apache.beehive.controls.api.bean.Control;
import org.apache.beehive.netui.pageflow.Forward;

@Jpf.Controller(simpleActions = { @Jpf.SimpleAction(name = "begin", path = "index.jsp") })
public class ShopController extends PageFlowController {
	private static final long serialVersionUID = 638703091L;
	@Control
	private ShopServiceControl shopServiceControl;
	private ProductVO[] allProducts = null;
	private Invoice cart = null;
	private boolean accountValid = false;
	
	/**
	 * allProducts is cached, as the products are stable, it's faster, and easier during development.
	 * @return
	 */
	public ProductVO[] getAllProducts() {
		if (allProducts == null) {
			allProducts = shopServiceControl.getAllProducts(); 
		}
		return allProducts;
	}
	public Invoice getCart() {
		return cart;
	}
	public boolean isAccountValid() {
		return accountValid;
	}
	public String getEndpoint() {
		return shopServiceControl.getEndpointAddress();
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "cart.jsp") })
	public Forward newCart(NewCartFormBean form) {
		Forward forward = new Forward("success");
		java.lang.String client_arg = form.getClient_arg();
		shopServiceControl.newCart(client_arg);
		cart = shopServiceControl.getCart();
		return forward;
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "cart.jsp") })
	public Forward addItem(AddItemFormBean form) {
		System.out.println("ShopController.addItem()");
		Forward forward = new Forward("success");
		java.lang.String supplier_arg = form.getSupplier_arg();
		java.lang.String code_arg = form.getCode_arg();
		int qty_arg = form.getQty_arg();
		shopServiceControl.addItem(supplier_arg, code_arg, qty_arg);
		cart = shopServiceControl.getCart();
		return forward;
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "cart.jsp",
			actionOutputs = { @Jpf.ActionOutput(name = "setAccountResult", type = java.lang.String.class) }) })
	public Forward setAccount(SetAccountFormBean form) {
		Forward forward = new Forward("success");
		java.lang.String accountName_arg = form.getAccountName_arg();
		java.lang.String accountPassword_arg = form.getAccountPassword_arg();
		accountValid = shopServiceControl.setAccount(accountName_arg, accountPassword_arg);
		cart.setAccountName(accountName_arg);
		forward.addActionOutput("setAccountResult",
				("account " + accountName_arg + (accountValid?" ":" in") + "valid"));
		return forward;
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "index.jsp",
			actionOutputs = { @Jpf.ActionOutput(name = "cancelOrderResult", type = java.lang.String.class) }) })
	public Forward cancelOrder() {
		Forward forward = new Forward("success");
		java.lang.String cancelOrderResult = shopServiceControl.cancelOrder();
		forward.addActionOutput("cancelOrderResult", cancelOrderResult);
		return forward;
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "orderComplete.jsp", actionOutputs = { @Jpf.ActionOutput(name = "confirmOrderResult", type = jarden.shop.Invoice.class) }) })
	public Forward confirmOrder() throws john.ws.bank.BankException {
		Forward forward = new Forward("success");
		jarden.shop.Invoice confirmOrderResult = shopServiceControl.confirmOrder();
		forward.addActionOutput("confirmOrderResult", confirmOrderResult);
		return forward;
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "index.jsp") })
	public Forward home() {
		Forward forward = new Forward("success");
		return forward;
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "cart.jsp") })
	public Forward selectProduct() {
		AddItemFormBean form = new AddItemFormBean();
		ServletRequest request = this.getRequest();
		form.setCode_arg(request.getParameter("code"));
		form.setSupplier_arg(request.getParameter("supplier"));
		form.setQty_arg(1);
		Forward forward = new Forward("success", form);
		return forward;
	}
	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "index.jsp") })
	public Forward setEndpointAddress(SetEndpointAddressFormBean form) {
		Forward forward = new Forward("success");
		java.lang.String p0 = form.getP0();
		shopServiceControl.setEndpointAddress(p0);
		return forward;
	}

	/**
	 * Callback that is invoked when this controller instance is created.
	 */
	@Override
	protected void onCreate() {
	}

	/**
	 * Callback that is invoked when this controller instance is destroyed.
	 */
	@Override
	protected void onDestroy(HttpSession session) {
	}

	@Jpf.FormBean
	public static class NewCartFormBean implements java.io.Serializable {
		private static final long serialVersionUID = 641158705L;
	
		private java.lang.String client_arg;
	
		public NewCartFormBean() {
		}
	
		public java.lang.String getClient_arg() {
			return client_arg;
		}
	
		public void setClient_arg(java.lang.String client_arg) {
			this.client_arg = client_arg;
		}
	}

	@Jpf.FormBean
	public static class AddItemFormBean implements java.io.Serializable {
		private static final long serialVersionUID = 1571913955L;
	
		private int qty_arg;
	
		private java.lang.String code_arg;
	
		private java.lang.String supplier_arg;
	
		public AddItemFormBean() {
		}
	
		public int getQty_arg() {
			return qty_arg;
		}
	
		public void setQty_arg(int qty_arg) {
			this.qty_arg = qty_arg;
		}
	
		public java.lang.String getCode_arg() {
			return code_arg;
		}
	
		public void setCode_arg(java.lang.String code_arg) {
			this.code_arg = code_arg;
		}
	
		public java.lang.String getSupplier_arg() {
			return supplier_arg;
		}
	
		public void setSupplier_arg(java.lang.String supplier_arg) {
			this.supplier_arg = supplier_arg;
		}
	}

	@Jpf.FormBean
	public static class SetAccountFormBean implements java.io.Serializable {
		private static final long serialVersionUID = 1782648265L;
	
		private java.lang.String accountPassword_arg;
	
		private java.lang.String accountName_arg;
	
		public SetAccountFormBean() {
		}
	
		public java.lang.String getAccountPassword_arg() {
			return accountPassword_arg;
		}
	
		public void setAccountPassword_arg(java.lang.String accountPassword_arg) {
			this.accountPassword_arg = accountPassword_arg;
		}
	
		public java.lang.String getAccountName_arg() {
			return accountName_arg;
		}
	
		public void setAccountName_arg(java.lang.String accountName_arg) {
			this.accountName_arg = accountName_arg;
		}
	}

	@Jpf.FormBean
	public static class SetEndpointAddressFormBean implements java.io.Serializable {
		private static final long serialVersionUID = -499765629L;
	
		private java.lang.String p0;
	
		public SetEndpointAddressFormBean() {
		}
	
		public java.lang.String getP0() {
			return p0;
		}
	
		public void setP0(java.lang.String p0) {
			this.p0 = p0;
		}
	}
}