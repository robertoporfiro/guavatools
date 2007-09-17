package joe.ws.cart;

public interface BankWSServiceControlSEI extends java.rmi.Remote
{

    public int changePassword(java.lang.String userName,java.lang.String oldPassword,java.lang.String newPassword) throws java.rmi.RemoteException, john.ws.bank.BankException;

    public double getBalance(java.lang.String userName,java.lang.String password) throws java.rmi.RemoteException, john.ws.bank.BankException;

    public john.db.JohnLogVO[] getTransactionLog(java.lang.String userName,java.lang.String password) throws java.rmi.RemoteException, john.ws.bank.BankException;

    public double transfer(java.lang.String fromName,java.lang.String password,java.lang.String toName,double amount) throws java.rmi.RemoteException, john.ws.bank.BankException;

}