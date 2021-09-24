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
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import static java.util.concurrent.TimeUnit.SECONDS;
import javax.swing.Timer;

/**
 *
 * @author Angelica Figueroa Muñiz
 */
public class ImmigrationSimulator extends GUISimulator implements Simulable{
    private ImmigrationGrille immigration;

    public ImmigrationSimulator(){
        super(500, 500, Color.BLACK);
        immigration = new ImmigrationGrille(40);
        immigration.fillGrille();
        addElements();
    }

    public ImmigrationGrille getImmigration() {
        return immigration;
    }
    
    public EventManager getEventManager(){
        return this.manager;
    }
    
    public void addElements() {
        int a = 0;
        int b = 0;
        for (int j = 0; j < immigration.dimension; j++) {
            b += 15;
            a = 10;
            for (int i = 0; i < immigration.dimension; i++) {
                switch (immigration.grille[i][j].state) {
                    case 0:
                        addGraphicalElement(new Rectangle(immigration.grille[i][j].coordX + a, immigration.grille[i][j].coordY + b, new Color(244,89,5), new Color(244,89,5), 10, 10));
                        break;
                    case 1:
                        addGraphicalElement(new Rectangle(immigration.grille[i][j].coordX + a, immigration.grille[i][j].coordY + b, new Color(199,13,58), new Color(199,13,58), 10, 10));
                        break;
                    case 2:
                        addGraphicalElement(new Rectangle(immigration.grille[i][j].coordX + a, immigration.grille[i][j].coordY + b, new Color(81,44,98), new Color(81,44,98), 10, 10));
                        break;
                    case 3:
                        addGraphicalElement(new Rectangle(immigration.grille[i][j].coordX + a, immigration.grille[i][j].coordY + b, new Color(69,150,155), new Color(69,150,155), 10, 10));
                        break;
                }
                a += 15;
            }
        }
    }
    
    @Override
    public void next() {

        manager.add(new ImmigrationEvent(0, this));
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
