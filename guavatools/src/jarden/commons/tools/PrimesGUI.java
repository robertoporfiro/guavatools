package jarden.commons.tools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PrimesGUI {
    JFrame frame;
    JPanel contentPanel;
    JLabel latestPrime;
    JLabel numberOfPrimesFound;
    JLabel heapStats;
    JLabel runningTime;
    JLabel primesPerMinute;
    JLabel nextMilestone;
    
    public boolean showtime=true;
    public long statsRefreshInterval=1000;
    private Primes primes;
    private String latestPrimeText="current prime: ";
    private String numberOfPrimesFoundText="found so far: ";
    private String heapStatText="heap usage: ";
    private String runningTimeText="elapsed: ";
    private String ppmText="find rate(cur/max): ";
    private String nextMilestoneText="next milestone (M/G):";
    
    NumberFormat formatter = NumberFormat.getIntegerInstance();
    
    public void launch(Primes primes){
        this.primes = primes;
        frame = new JFrame("Tests");
        
        
        contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(6,0));
        frame.getContentPane().setBackground(Color.WHITE);
        
               
        latestPrime = new JLabel(latestPrimeText);
        contentPanel.add(latestPrime);
        numberOfPrimesFound = new JLabel(numberOfPrimesFoundText);
        contentPanel.add(numberOfPrimesFound);
        heapStats = new JLabel(heapStatText);
        contentPanel.add(heapStats);
        runningTime = new JLabel(runningTimeText);
        contentPanel.add(runningTime);
        primesPerMinute = new JLabel(ppmText);
        primesPerMinute.setToolTipText("how fast we are finding primes in this session");
        contentPanel.add(primesPerMinute);
        nextMilestone = new JLabel(nextMilestoneText);
        nextMilestone.setToolTipText("The amount of time it will take to reach the next Million (M) / Billion (G)");
        contentPanel.add(nextMilestone);
        
        JPanel spacerPanel = new JPanel();
        spacerPanel.setMinimumSize(new Dimension(100,100));
        
        frame.getContentPane().add(spacerPanel,BorderLayout.WEST);        
        frame.getContentPane().add(contentPanel,BorderLayout.CENTER);
        setUpListeners();
        
        frame.setSize(250,180);
        frame.setVisible(true);
        
        Runnable updater = new StatsUpdater();
        Thread updaterThread = new Thread(updater);
        
        updaterThread.start();
        
    }

    public void refresh() {
        Stats stats = primes.getStats();
        latestPrime.setText(latestPrimeText+formatter.format(stats.getLatestPrime()));
        numberOfPrimesFound.setText(numberOfPrimesFoundText+ formatter.format(stats.getNumberOfPrimesFound()));
        heapStats.setText(heapStatText+stats.getHeapStats());
        runningTime.setText(runningTimeText+stats.getElapsedTime());
        primesPerMinute.setText(ppmText+stats.getPrimesFoundPerMinute()+" / "+stats.getHighestFindRate()+" per min");
        nextMilestone.setText(nextMilestoneText+stats.getTimeToNextMillionMilestoneText()+" / "+(stats.getSecondsToNextBillionMilestoneText()));        
    }
    
    class StatsUpdater implements Runnable{
        public void run() {
            System.out.println("stats updater started");
            while(showtime){
                try {
                    refresh();
                    Thread.sleep(statsRefreshInterval);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }        
    }
    
    
    private void setUpListeners() {
        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent evt) {
                showtime=false;
                System.exit(0);
            }
        });
        
    }


   
}
