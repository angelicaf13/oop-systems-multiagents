/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import gui.GUISimulator;

/**
 *
 * @author Angelica Figueroa Muñiz
 * Event class for the Conway model of cellules. This class extends from Event
 * and implements the execute method.
 */
public class ConwayEvent extends Event{
    private ConwaySimulator c;

    public ConwayEvent(int date, ConwaySimulator c) {
        super(date);
        this.c = c;
    }

    /**
     * This method updates the grille and repaints the cellules once the grille
     * is updated. It also adds a new event to the Event Manager. 
     */
    @Override
    public void execute() {
        c.getConway().updateGrille();
        c.addElements();
        c.getManager().add(new ConwayEvent(super.getDate() + 1, c));
    }
    
}
