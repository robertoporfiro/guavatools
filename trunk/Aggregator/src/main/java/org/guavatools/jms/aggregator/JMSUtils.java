package org.guavatools.jms.aggregator;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import weblogic.jndi.Environment;


/**
 * A helper class which takes care of looking up JMS resources in JNDI
 * @author peet.denny
 *
 */
public class JMSUtils {
	private Context context;
	private Logger log = Logger.getLogger(JMSUtils.class);
	private ConnectionFactory confac;
	
	private String connectionString;
	private String confacName;
	private String queueName;

	public  Queue getInboundQueue() throws NamingException {
		return (Queue) getContext().lookup(queueName);
	}
	
	public Context getContext() throws NamingException {
		if(context == null){
			Environment env = new Environment();
			env.setProviderUrl(connectionString);
			context = env.getInitialContext();
		}
		return context;
	}

	public QueueSession getQueueSession(Queue queue) throws NamingException, JMSException {
		ConnectionFactory confac = getConnectionFactory();
		QueueConnection qCon = (QueueConnection) confac.createConnection();
		qCon.start();
		return qCon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
	}

	private ConnectionFactory getConnectionFactory() throws NamingException {
		if(confac == null){
			confac = (ConnectionFactory) getContext().lookup(confacName);
			log.debug("retrieved connection factory: "+confac);
		}
		return confac;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	public void setConfacName(String confacName) {
		this.confacName = confacName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

}

