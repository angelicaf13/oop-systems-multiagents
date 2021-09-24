/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Angelica Figueroa Muñiz
 */
public class SchellingGrille extends Grille{
    private Color[] colors = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.MAGENTA, Color.BLACK};

    public SchellingGrille(int d) {
        super(d);
    }

    public Color[] getColors() {
        return colors;
    }
    
    @Override
    public void fillGrille() {
        for (int j = 0; j < this.dimension; j++) {
            for (int i = 0; i < this.dimension; i++) {
                Schelling n = new Schelling(0, 0, i , j, 0);
                n.setColorRandom();
                n.setStateRandom();
                if(n.getState() == 0){ //If the state equals 0, the habitation is vacante, so we add it to the ArrayList
                    n.setColor(-1);
                    n.getVacantes().add(n);
                }
                this.grille[i][j] = n;
            }
        }
    }

    @Override
    public void updateGrille() {
        for (int j = 0; j < this.dimension; j++) {
            for (int i = 0; i < this.dimension; i++) {
                this.grille[i][j].checkNeighbors(this.grille[i][j].getState(), this.dimension, this.dimension, this.grille, this.grille);
            }
        }
        //grille = newGrille;
    }
}
