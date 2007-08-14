package john.ws.client;

public interface BankWSServiceControlSEI extends java.rmi.Remote
{

    public void debit(java.lang.String account,double amount) throws java.rmi.RemoteException;

}