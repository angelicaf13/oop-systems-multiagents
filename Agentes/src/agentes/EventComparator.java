/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import java.util.Comparator;

/**
 *
 * @author Angelica Figueroa Muñiz
 */
public class EventComparator implements Comparator<Event>{

    @Override
    public int compare(Event t, Event t1) {
        return t.getDate() - t1.getDate();
    }
    
}
