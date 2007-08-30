package jarden.demo.buffering;

import java.util.LinkedList;
import java.util.Queue;

public class TestBufferBehaviour {
    
    Queue<String> store = new LinkedList<String>();
    
    public static void main(String[] args) {
        TestBufferBehaviour b = new TestBufferBehaviour();
        b.launch();
    }
    
    public void launch(){
        store.add("Peet");
        store.add("Sam");
        store.add("Kelvin");
        
        giveTalkToSpeaker("Sam");
        
        giveTalkToSpeaker();
        giveTalkToSpeaker();
        giveTalkToSpeaker();
        giveTalkToSpeaker();
        giveTalkToSpeaker();
        
    }
    
    private void giveTalkToSpeaker(String speaker) {
        store.remove(speaker);
        store.add(speaker);
        System.out.println("Just given a talk to:: "+speaker);
        System.out.println("New ordering is: "+store);
    }

    public void giveTalkToSpeaker(){
        String speaker = store.poll();
        store.add(speaker);
        System.out.println("Just given a talk to: "+speaker);
        System.out.println("New ordering is: "+store);
    }

}
