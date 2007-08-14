package john.web.hello;

public interface HelloWSServiceControlSEI extends java.rmi.Remote
{

    public java.lang.String hello(java.lang.String name) throws java.rmi.RemoteException;

    public java.lang.String logMessage(java.lang.String message) throws java.rmi.RemoteException;

    public java.lang.String longHello(java.lang.String name,int delay) throws java.rmi.RemoteException;

    public java.lang.String samlHello(java.lang.String name) throws java.rmi.RemoteException;

}