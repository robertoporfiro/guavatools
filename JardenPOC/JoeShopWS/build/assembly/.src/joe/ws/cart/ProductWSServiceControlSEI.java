package joe.ws.cart;

public interface ProductWSServiceControlSEI extends java.rmi.Remote
{

    public john.db.ProductVO[] getAllProducts() throws java.rmi.RemoteException;

    public john.db.ProductVO[] getMatchingProducts(john.db.ProductVO vo) throws java.rmi.RemoteException;

    public john.db.ProductVO getProduct(java.lang.String supplier,java.lang.String code) throws java.rmi.RemoteException;

}