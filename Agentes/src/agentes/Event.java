package agentes;

import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Angelica Figueroa Muñiz
 */
public abstract class Event implements Comparable<Event>{
    private int date;
    
    public Event(int date){
        this.date = date;
    }

    public int getDate() {
        return date;
    }
    
    public abstract void execute();
    
    @Override
    public int compareTo(Event n){
        int compareDate = n.getDate();
        
        return this.getDate() - n.getDate();
        
    }

    
    
  
}
