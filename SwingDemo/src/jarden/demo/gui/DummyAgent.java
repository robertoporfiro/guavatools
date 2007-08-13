package jarden.demo.gui;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Random;

/**
 * this class pretends to be the agent. It has a timer which mimics data arriving from the network. the purpose of this class is to demonstrate how to
 * set up communication between the agent and the GUI.
 * 
 * @author GBEVVH8
 */
public class DummyAgent {
    String tickerLabel = "BEASYS=";
    private UserData currentUserData;
    GUI gui;
    
    public DummyAgent(){
        gui = new GUI(this);
        gui.launch();
        this.launch();
    }
    
    private void launch() {
        DataPoller poller = new DataPoller();
        Thread t = new Thread(poller);
        t.start();
        // wait until the poller is finished before exiting (i.e. never)
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            // and then ignore
        }

    }

    
    
    public void setStockTicker(String data){
        this.tickerLabel = data+"=";
    }
    
    
    /**
     * In this method, we receive and handle the data from the GUI.
     * Here, we will print out the data to the command line, and also update the stockTicker, so that the data sent to the 
     * GUI have a different company name
     */
    public void setCurrentUserData(UserData data){
        System.out.println("GUI data received in agent:\n"+data);
        this.currentUserData = data;
        setStockTicker(currentUserData.getStockCode());        
    }
    
    public UserData getCurrentUserData() {
        return currentUserData;
    }

    public String getStockTickerLabel(){
        return this.tickerLabel;
    }
    
    
    
    // this is the method that the poller will invoke when new data arrives
    // although the poller will send random data every few seconds, it behaves in the same way as your agent will when new
    // data arrives from the network
    private void onNewNetworkData(String data) {
        System.out.println("new stock price has arrived: " + data);
        gui.handleIncomingAgentData(data);
    }

    // timer inner class which polls the DummyAgent every few seconds with some new Data
    // If you haven't done much threading, don't worry about the workings of this class. You won't need it in your model
    // This class pretends to poll the DummyAgent every 5 seconds with the stock price of BEA systems

    public class DataPoller implements Runnable {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        Random r = new Random(new Date().getTime());

        public void run() {
            while (true) {
                double amt = generateDoublePrice();
                String stockPrice = tickerLabel + formatter.format(amt);
                // send data to Agent
                onNewNetworkData(stockPrice);

                // wait for some seconds

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    // ignore
                }
            }
        }

        private double generateDoublePrice() {
            double amt = r.nextDouble();
            return (amt * 2) + 11;
        }

    }
    
    

    public static void main(String[] args) {
        new DummyAgent();
    }


}
