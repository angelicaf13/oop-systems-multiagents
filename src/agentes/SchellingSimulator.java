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
 */
public class SchellingSimulator extends GUISimulator implements Simulable {

    private SchellingGrille schelling;

    public SchellingSimulator() {
        super(700, 700, Color.BLACK);
        schelling = new SchellingGrille(40);
        schelling.fillGrille();
        addElements();
    }

    public SchellingGrille getSchelling() {
        return schelling;
    }

    public void addElements() {
        int a = 0;
        int b = 0;
        for (int j = 0; j < schelling.dimension; j++) {
            b += 15;
            a = 15;
            for (int i = 0; i < schelling.dimension; i++) {
                Schelling r = (Schelling) schelling.grille[i][j];
                if (r.getState() == 0) {
                    addGraphicalElement(new Rectangle(schelling.grille[i][j].coordX + a, schelling.grille[i][j].coordY + b, Color.WHITE, Color.WHITE, 10, 10));
                } else {
                    switch (r.getColor()) {
                        case 0:
                            addGraphicalElement(new Rectangle(schelling.grille[i][j].coordX + a, schelling.grille[i][j].coordY + b, new Color(69, 150, 155), new Color(69, 150, 155), 10, 10));
                            break;
                        case 1:
                            addGraphicalElement(new Rectangle(schelling.grille[i][j].coordX + a, schelling.grille[i][j].coordY + b, new Color(199, 13, 58), new Color(199, 13, 58), 10, 10));
                            break;
                        case 2:
                            addGraphicalElement(new Rectangle(schelling.grille[i][j].coordX + a, schelling.grille[i][j].coordY + b, new Color(81, 44, 98), new Color(81, 44, 98), 10, 10));
                            break;
                        case 3:
                            addGraphicalElement(new Rectangle(schelling.grille[i][j].coordX + a, schelling.grille[i][j].coordY + b, new Color(244, 89, 5), new Color(244, 89, 5), 10, 10));
                            break;
                        case 4:
                            addGraphicalElement(new Rectangle(schelling.grille[i][j].coordX + a, schelling.grille[i][j].coordY + b, Color.cyan, Color.cyan, 10, 10));
                            break;
                        case 5:
                            addGraphicalElement(new Rectangle(schelling.grille[i][j].coordX + a, schelling.grille[i][j].coordY + b, Color.green, Color.green, 10, 10));
                            break;
                    }
                }

                a += 15;
            }
        }
    }

    @Override
    public void next() {
        manager.add(new SchellingEvent(0, this));
        super.timer = new Timer((int) super.speedSpinner.getValue(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                manager.next();
            }
        });
        timer.start();
    }

    @Override
    public void restart() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
