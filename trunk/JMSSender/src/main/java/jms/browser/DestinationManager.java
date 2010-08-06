package jms.browser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.NamingException;

import jms.browser.DestinationInfo.DestinationType;
import jms.browser.util.PropertyManger;

import org.apache.log4j.Logger;

import weblogic.jndi.Environment;



public class DestinationManager {
	private Logger log = Logger.getLogger(DestinationManager.class);
	private Collection<DestinationInfo> destinationInfoCollection;
	private Map<String, Context> namingContextsByURL = new HashMap<String, Context>();
	private Map<DestinationInfo, Destination> destinations = new HashMap<DestinationInfo, Destination>();

	public Collection<Destination> getDestinations() throws IOException, ClassNotFoundException, NamingException {
		destinationInfoCollection = getDestinationInfoFromFile();
		Collection<Destination>  destinations = new ArrayList<Destination>();
		for(DestinationInfo info: destinationInfoCollection){
			destinations.add(getDestination(info));
		}
		return destinations;
	}
	
	/**
	 * returns existing destination or creates it
	 * @param info
	 * @return
	 * @throws NamingException
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public Destination getDestination(DestinationInfo info) throws NamingException,IOException{
		Destination destination = destinations.get(info);
		if(destination != null){
			return destination;
		}
		Context ctx = getInitialContextForServerURL(info.getServerUrl());
		destination = (Destination) ctx.lookup(info.getDestinationName());
		destinations.put(info, destination);
		log.info("adding new destination to store");
		if(! destinationInfoCollection.contains(info)){
			addInfoToStore(info);
		}
		return destination;
	}

	
	
	private void addInfoToStore(DestinationInfo info) throws FileNotFoundException, IOException {
		destinationInfoCollection.add(info);
		ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(getFileStore()));
		oss.writeObject(destinationInfoCollection);
		oss.close();
		log.info("successfully wrote destination info to store");
		
	}

	private Context getInitialContextForServerURL(String serverUrl) throws NamingException {
		Context context = namingContextsByURL.get(serverUrl);
		if(context == null){
			Environment env = new Environment();
			env.setProviderUrl(serverUrl);
			context = env.getInitialContext();
			namingContextsByURL.put(serverUrl, context);
			log.info("Adding initial context to store: "+serverUrl);
		}
		return context; 
		
	}

	@SuppressWarnings("unchecked")
	public Collection<DestinationInfo> getDestinationInfoFromFile() throws IOException, ClassNotFoundException {
		if(destinationInfoCollection != null){
			return destinationInfoCollection;
		}
		File file = getFileStore();
		if(file.length()<=0){
			destinationInfoCollection = new ArrayList<DestinationInfo>();
			return destinationInfoCollection;
		}
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Object objectIn = ois.readObject();
		Collection<DestinationInfo> fileNames = null;
		if(objectIn != null && objectIn instanceof Collection){
			fileNames = (Collection<DestinationInfo>) objectIn;
		}
		else{
			fileNames = new ArrayList<DestinationInfo>();
		}
		destinationInfoCollection = fileNames;
		return fileNames;
	}
	
	
	private File getFileStore() throws IOException {
		String fileName = PropertyManger.getProperty("destination.store.filename");
		File file = new File(fileName);
		if(file.createNewFile()){
			log.debug("created new file at: "+file.getAbsolutePath());
		}
		return file;
	}

	//----------------------------------- SINGLETON STUFF --------------------------
	
	
	private DestinationManager(){
		try {
			getDestinationInfoFromFile();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	private static DestinationManager instance = new DestinationManager();
	public static DestinationManager getDestinationManager(){
		return instance;
	}

	public QueueBrowser getQueueBrowser(DestinationInfo info) throws JMSException, NamingException, IOException {
		if(!info.getDestinationType().equals(DestinationType.Queue)){
			throw new RuntimeException("Unable to create a queue browser for a topic");
		}
			
		Context ctx = getInitialContextForServerURL(info.getServerUrl());
		ConnectionFactory confac = (ConnectionFactory) ctx.lookup(info.getConfacName());
		QueueConnection qCon = (QueueConnection) confac.createConnection();
		QueueSession session  = qCon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		return session.createBrowser((Queue) getDestination(info));
	}
	

}

