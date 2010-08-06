package jms.browser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

import javax.jms.JMSException;
import javax.jms.QueueBrowser;
import javax.jms.TextMessage;
import javax.naming.NamingException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

import jms.browser.DestinationInfo.DestinationType;

import org.apache.log4j.Logger;




public class QueueBrowserGUI {
	private static final String IMGS_DIR = "etc/imgs/";


	private static final long DEFAULT_REFRESH_PERIOD = 5000;


	private Logger log = Logger.getLogger(this.getClass().getName());
//	private BeanFactory factory = new XmlBeanFactory(new ClassPathResource("spring-ejb.xml"));

	
	int windowWidth=1500;
	int windowHeight=800;
	private JFrame window;
	private JPanel queuePanel;
	Container contentPane;

	ImageIcon messageIcon = new ImageIcon(IMGS_DIR+"message.jpg");

	private DestinationManager destinationManager;
	private JPanel menuPanel = new JPanel();
	JPanel messageDetailPanel=  new JPanel();


	private JTextArea messageDetailArea;


	private TextMessage currentlyDisplayedMessage;


	private JTextField newDestinationNameTextField;


	private JTextField newDestinationConfacTextField;


	private JTextField newDestinationURLTextField;


	private JScrollPane queuePanelScroller;
	
	
	
	public static void main(String[] args) {
		QueueBrowserGUI gui = new QueueBrowserGUI();
		gui.launch();
	}


	private void launch() {
		initialiseDestinationManager();
		log.debug("launching GUI");
		window = new JFrame();
		window.setBounds(100, 100, windowWidth, windowHeight);
		contentPane = window.getContentPane();
		queuePanel = new JPanel();
		
		addMenuBar();
		addMessageDetailBar();
		try {
			renderQueuePanel();
		} catch (Exception e) {
			handleError(e);
		}
		setListeners();
		
//		startRefreshThread(DEFAULT_REFRESH_PERIOD);
		
		window.setVisible(true);
		
	}

	
	
	


	private void startRefreshThread(final long updateDelay) {
		Runnable refreshRunnable = new Runnable(){
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(updateDelay);
					} catch (InterruptedException e) {
						e.printStackTrace();// otherwise ignore
					}
					try {
//						renderQueuePanel();
					} catch (Exception e) {
						handleError(e);
					}
				}
			}
		};		
		Thread t =  new Thread(refreshRunnable);
		t.start();
		log.info("started refresh thread");
	}
	


	private void addMessageDetailBar() {
		messageDetailPanel.setBounds(new Rectangle(50,windowHeight));
		messageDetailPanel.setLayout(new GridLayout(3,1));
		messageDetailPanel.setAlignmentX(50.0f);
		messageDetailPanel.setBackground(Color.LIGHT_GRAY);
		addPadPanels(messageDetailPanel,1);
		messageDetailArea = new JTextArea(70,30);
		messageDetailPanel.add(messageDetailArea);
		JButton consumeButton = new JButton("Consume");
		consumeButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent evt) {
				if(currentlyDisplayedMessage != null){
					try {
						currentlyDisplayedMessage.acknowledge();
						removeMessageFromDisplay();
					} catch (Exception e) {
						handleError(e);
					}
				}
			}

			
		});
//		addPadPanels(messageDetailPanel,1);
		addPaddedComponent(messageDetailPanel, consumeButton);
		contentPane.add(messageDetailPanel,BorderLayout.EAST);
	}


	private void addPadPanels(JPanel panel, int noOfPanels) {
		for(int i=0;i<noOfPanels;i++){
			JPanel padPanel = new JPanel();
			panel.add(padPanel);
		}
	}

	private void removeMessageFromDisplay() throws IOException, ClassNotFoundException, NamingException, JMSException {
		currentlyDisplayedMessage = null;
		messageDetailArea.setText("");
		renderQueuePanel();
	}
	
	
	private void addMenuBar() {
		menuPanel.setBounds(new Rectangle(50,windowHeight));
		menuPanel.setLayout(new GridLayout(10,1));
		menuPanel.setAlignmentX(50.0f);
		menuPanel.setBackground(Color.LIGHT_GRAY);
		
		newDestinationURLTextField = new JTextField(20);
		addPaddedComponent(menuPanel, new JLabel("Host URL"));
		addPaddedComponent(menuPanel, newDestinationURLTextField);
		
		
		newDestinationNameTextField = new JTextField(20);
		addPaddedComponent(menuPanel, new JLabel("destination name"));
		addPaddedComponent(menuPanel, newDestinationNameTextField);
		
		newDestinationConfacTextField = new JTextField(20);
		addPaddedComponent(menuPanel, new JLabel("confac name"));
		addPaddedComponent(menuPanel, newDestinationConfacTextField);
		
		
		
		JButton submitButton  = new JButton("add");
		submitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				log.info("creating new queue info");
				DestinationInfo info = new DestinationInfo();
				info.setServerUrl(newDestinationURLTextField.getText());
				info.setConfacName(newDestinationConfacTextField.getText());
				info.setDestinationName(newDestinationNameTextField.getText());
				info.setDestinationType(DestinationType.Queue);
				
				try {
					DestinationManager.getDestinationManager().getDestination(info);
					renderQueuePanel();
				} catch (Exception e1) {
					handleError(e1);
				}
				
				newDestinationConfacTextField.setText("");
				newDestinationNameTextField.setText("");
				newDestinationURLTextField.setText("");
			}
			
		});
		
		addPaddedComponent(menuPanel, submitButton);
		
		
		contentPane.add(menuPanel, BorderLayout.WEST);
	}


	private void addPaddedComponent(Container parent, Component child) {
		JPanel padPanel =new JPanel();
		padPanel.add(child);
		parent.add(padPanel);		
	}


	private void initialiseDestinationManager() {
		destinationManager = DestinationManager.getDestinationManager();	
//		DestinationInfo info = new DestinationInfo();
//		info.setConfacName("OSB.jms.InboundConnectionFactory");
//		info.setDestinationName("jms/OSB.AggregatorSortQueue");
//		info.setServerUrl("t3://localhost:7001");
//		info.setDestinationType(DestinationType.Queue);
//		try {
//			destinationManager.getDestination(info);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
	}


	@SuppressWarnings("unchecked")
	private void renderQueuePanel() throws IOException, ClassNotFoundException, NamingException, JMSException {
		log.debug("run by thread:" +Thread.currentThread().getName());
		Runnable queuePanelRenderer = new Runnable(){
			@Override
			public void run() {
				try{
					window.getContentPane().remove(queuePanelScroller);
				}catch(NullPointerException e){
					// ignore
				}
				Collection<DestinationInfo> destinations;
				try {
					destinations = destinationManager.getDestinationInfoFromFile();
					log.info("found "+destinations.size()+" destinations");
				 
	//				queuePanel.removeAll();
	//				queuePanel.setBackground(Color.CYAN);
					queuePanel.setLayout(new GridLayout((destinations.size()*4)+1,1)); // two empty cells below each queue info and one at the top
					queuePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
					queuePanelScroller = new JScrollPane(queuePanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
					window.getContentPane().add(queuePanelScroller, BorderLayout.CENTER);
					addRefreshButton();
					for(DestinationInfo info: destinations){
						JPanel queueInfoPanel = new JPanel();
						
						populateQueueInfoPanel(queueInfoPanel, info);
						queuePanel.add(queueInfoPanel);
						
						if(DestinationType.Queue.equals(info.getDestinationType())){
							renderQueueInfo(info);
						}
						
						addQueueInfoButtonStrip();
						addPadPanels(queuePanel, 1);
					}
					log.debug("finished rendering panel");
				} catch (Exception e) {
					handleError(e);
				}
		
				
			}
		};
				
		
			Thread t = new Thread(queuePanelRenderer);
			t.setDaemon(true);
			t.start();
		}
			
	
		
	


	private void addRefreshButton() {
		ImageIcon icon = new ImageIcon(IMGS_DIR+"refresh.jpg");
		JButton refreshButton = new JButton(icon);
		refreshButton.setToolTipText("refreshes the state of the queues");
		refreshButton.setBackground(Color.white);
		refreshButton.setMaximumSize(new Dimension(20,20));
		Container flowPanel = new JPanel();
		flowPanel.add(refreshButton);
		refreshButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent evt) {
				try {
					Runnable refresher =new Runnable(){
						@Override
						public void run() {
							try {
								renderQueuePanel();
							} catch (Exception e) {
								handleError(e);
							}
						}
					};
	
					Thread t = new Thread(refresher);
					t.start();
				} catch (Exception e) {
					handleError(e);
				}
			}
			
		});
		queuePanel.add(flowPanel);		
		
	}


	private void handleError(Exception e) {
		log.error(e);
		JOptionPane.showMessageDialog(this.window,e.toString(), "Error",JOptionPane.ERROR_MESSAGE);
		throw new RuntimeException(e);
	}

	
	
	private void addQueueInfoButtonStrip() {
		JPanel buttonStrip = new JPanel();
		JButton deleteButton = new JButton("delete");
		JButton drainButton = new JButton("drain");
		buttonStrip.add(deleteButton);
		buttonStrip.add(drainButton);
		queuePanel.add(buttonStrip);
	}


	private void populateQueueInfoPanel(JPanel queueInfoPanel,	DestinationInfo info) {
		StringBuffer buf = new StringBuffer();
		buf.append("<HTML>");
		buf.append("Host: ");
		buf.append(info.getServerUrl());
		buf.append("<br/>Queue name: ");
		buf.append(info.getDestinationName());
		buf.append("<br/>Type: ");
		buf.append(getQueueLabel(info));
		buf.append("<br/>Connection Fac: ");
		buf.append(info.getConfacName()+"<br/>");
		buf.append("</HTML>");
		JPanel flowPanel = new JPanel();
		flowPanel.setBackground(Color.LIGHT_GRAY);
		flowPanel.add(new JLabel(buf.toString()));
		queueInfoPanel.add(flowPanel);
	}


	@SuppressWarnings("unchecked")
	private void renderQueueInfo(DestinationInfo info) throws JMSException, NamingException, IOException {
		QueueBrowser browser = destinationManager.getQueueBrowser(info);
		Enumeration messages = browser.getEnumeration();
		Collection<TextMessage> textMessages = new ArrayList<TextMessage>();
		while(messages.hasMoreElements()){
			TextMessage message = (TextMessage) messages.nextElement();
			textMessages.add(message);
		}
		JPanel holder = new JPanel();
		int idx=1;
		for(TextMessage mess: textMessages){
			JPanel messageDetailPanel = new JPanel();
			JButton button = new JButton(""+idx++,this.messageIcon);
			addButtonListener(button, mess);
			messageDetailPanel.add(button);
			holder.add(messageDetailPanel);
		}
		JScrollPane messagePanel = new JScrollPane(holder, JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		messagePanel.setPreferredSize(new Dimension(1000,80));
		
		addPaddedComponent(queuePanel, messagePanel);
		
	}


	private void addButtonListener(JButton button, final TextMessage mess) {
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				updateTextDetailPanel(mess);
			}
		
		});
		
	}


	private String getQueueLabel(DestinationInfo info) {
		return DestinationType.Queue.equals(info.getDestinationType()) ? "Queue" : "Topic";
	}
	

	private void updateTextDetailPanel(TextMessage mess) {
		try {
			this.currentlyDisplayedMessage = mess;
			this.messageDetailArea.setText(formatMessageDetails(mess));
			
		} catch (JMSException e) {
			handleError(e);
		}
	}



	@SuppressWarnings("unchecked")
	private String formatMessageDetails(TextMessage mess) throws JMSException {
		StringBuffer buf = new StringBuffer();
		buf.append("CorrelationId: ");
		buf.append(mess.getJMSCorrelationID());
		buf.append("\n");
		Enumeration<String> propertyNames = mess.getPropertyNames();
		while(propertyNames.hasMoreElements()){
			String propertyName = propertyNames.nextElement();
			String propertyValue = mess.getStringProperty(propertyName);
			buf.append(propertyName);
			buf.append(": ");
			buf.append(propertyValue);
			buf.append("\n");
		}
		buf.append("\n-----------\n");
		buf.append(mess.getText());
		return buf.toString();
	}


	private void setListeners() {
		window.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				log.info("closing window. Ciao bébé");
				System.exit(0);
			}
		});
	}

	class IconPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		Image img;

		  public IconPanel(Image img, int x, int y) {
		    this.img = img;
		    this.setMaximumSize(new Dimension(x,y));
		    this.setBounds(new Rectangle(x,y));
		  }

		  public void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    setBackground(Color.white);
		    Graphics2D g2 = (Graphics2D) g;

		    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		        RenderingHints.VALUE_ANTIALIAS_ON);

		    g2.setRenderingHint(RenderingHints.KEY_RENDERING,
		        RenderingHints.VALUE_RENDER_QUALITY);

		    g2.drawImage(img, 0, 0, 50, 500, this);
		  }
		}

}

