package john.web.jms;

public interface LogMessageJmsWSServiceControlSEI extends java.rmi.Remote
{

    public void logMessage(java.lang.String message) throws java.rmi.RemoteException;

    public void secureLogMessage(java.lang.String message) throws java.rmi.RemoteException;

}