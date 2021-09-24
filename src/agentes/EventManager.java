package agentes;


import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Angelica Figueroa Muñiz
 */
public class EventManager {
    private int currentDate = 0;
    private ArrayList <Event> events = new ArrayList();
    
    public void add(Event e){
        events.add(e);
        Collections.sort(events, new EventComparator());
    }
    
    public void next(){
        currentDate++;
        //System.out.println("Next... Current date: " + currentDate);
        while(!events.isEmpty() && events.get(0).getDate() <= currentDate){
            events.get(0).execute();
            events.remove(0);
        }
    }

    public ArrayList<Event> getEvents() {
        return events;
    }
    
    public boolean isFinished(){
        return events.isEmpty();
    }
    
    public void restart(){
    }
    
}
