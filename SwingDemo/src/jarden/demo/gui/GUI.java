package jarden.demo.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {

    // a reference to the DummyAgent
    DummyAgent agent;
    
    // Create all the bits that we need in the GUI.
    // I'm going to do this in Swing, which basically means adding J to the beginning of each word: JButton, JTextField etc
   
    JTextField nameField;
    JLabel nameLabel = new JLabel("name");
    JTextField addressField;
    JLabel addressLabel = new JLabel("address");
    JTextField yearsOfJavaField;
    JTextField companyField;
    JLabel companyLabel = new JLabel("stock label");
    
    JTextField tickerDataField;
    JLabel tickerDataLabel = new JLabel("currentPrice");
    
    JLabel yearsLabel = new JLabel("years of Java");
    JButton pageOneSubmitButton = new JButton("submit");
    JPanel pageOne = new JPanel();
    // a blank panel to fill the grid layout with
    JPanel blankPanel = new JPanel();
    JPanel bigBlankPanel = new JPanel();
    JFrame frame= new JFrame("Test GUI");
    
    public GUI(DummyAgent agent) {
            this.agent = agent;
    }


    public void launch(){
        buildPageOne();
        displayPage(pageOne);        
       
    }
    
    
    private void displayPage(JPanel pageName) {
        frame.getContentPane().add(pageName,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);        
    }


    private void buildPageOne() {
        pageOne.setLayout(new GridLayout(6,2));
        nameField = configurePageOneTextField(nameLabel);
        addressField = configurePageOneTextField(addressLabel);
        yearsOfJavaField= configurePageOneTextField(yearsLabel);
        companyField=configurePageOneTextField(companyLabel);
        
        JPanel buttonSpacer = new JPanel();
        buttonSpacer.add(pageOneSubmitButton);
        pageOne.add(buttonSpacer);
        
        
        addListeners();
             
    }


    /**
     * configures and adds a JTextField adds it to the pageOneLayout panel and then adds the specified label
     * @param label
     * @return
     */
    private JTextField configurePageOneTextField(JLabel label) {
        JTextField field = new JTextField(20);
        // we need to put this in a holder panel, because fields put directly into a frame will expand to the size of the frame :-(
        // Fields put into a panel will become their own preferred size.
        JPanel holderPanel = new JPanel();
        holderPanel.add(field);
        pageOne.add(holderPanel);
        pageOne.add(label);
        return field;
    }


    public void handleIncomingAgentData(String data){
        
    }
    


    private void addListeners() {
        frame.addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent arg0) {
                System.out.println("Exiting...");
                System.exit(0); // exit the virtual machine
            }
            
            
        });
        
    }
    
    
    
}
