/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import gui.GUISimulator;
import gui.Rectangle;
import gui.Simulable;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Angelica Figueroa Muñiz
 * A class that extends from the GUISimulator class and simulates the behavior
 * of the Conway's Game of Life.
 */
public class ConwaySimulator extends GUISimulator implements Simulable{
    private ConwayGrille conway;
    
    public ConwaySimulator(){
        super(500, 500, Color.BLACK);
        conway = new ConwayGrille(20);
        conway.fillGrille();
        addElements();
    }
    
    public EventManager getEventManager(){
        return manager;
    }
    
    public ConwayGrille getConway(){
        return this.conway;
    }
    
    /**
     * Method used for painting de cellules of a grille in the simulator window.
     */
    public void addElements(){
        int a = 0;
        int b = 0;
        for(int j = 0; j < conway.dimension; j++){
            b += 15;
            a = 15;
            for(int i = 0; i < conway.dimension; i++){
                if(conway.grille[i][j].state == 0){
                 addGraphicalElement(new Rectangle(conway.grille[i][j].coordX + a, conway.grille[i][j].coordY + b, new Color(199,13,58), new Color (199,13,58), 10, 10));
                }else{
                 addGraphicalElement(new Rectangle(conway.grille[i][j].coordX + a, conway.grille[i][j].coordY + b, new Color(69,150,155), new Color(69,150,155), 10, 10));
                }
                a += 15;
            }
        }
    }

    /**
     * This method is executed when the next button is pressed and keeps
     * executing sequentially.
     */
    @Override
    public void next() {
        
        manager.add(new ConwayEvent(0, this));
        super.timer = new Timer((int)super.speedSpinner.getValue(), new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                manager.next();
            }
        });
        timer.start();
        
    }
    
    @Override
    public void restart() {
    }
    
}
