/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import java.util.Random;

/**
 *
 * @author Angelica Figueroa Muñiz
 * Class used to represent the cells of the Immigration model, extends
 * from the abstract class Cellule.
 */
public class Immigration extends Cellule{

    public Immigration(int state, int noNeighbors, int coordX, int coordY) {
        super(state, noNeighbors, coordX, coordY);
        
    }

    /**
     * Method for validating which will be the next state of a cellule, depending
     * on her current state and the value of the attribute noNeighbors.
     * The value of noNeighbors will be the number of neighbors that are in the
     * next state that follows this cell state, if the cell has 3 or more 
     * neighbors in the next state and if the state of this cell is 3 then 
     * then her state becomes 0 (the first state of the cycle), if her current
     * state it's not 3 then her current state changes to the next state. If the
     * cell doesn't have 3 or more neighbors in the next state, then she keeps
     * her current state.
     * @param n a new Matrix where the modifications will be made.
     */
    @Override
    void validateNeighbors(Cellule[][] n) {
        if(this.noNeighbors >= 3){
            if(this.state == 3){
                n[this.coordX][this.coordY] = new Immigration(0, 0, this.coordX, this.coordY);
            }else{
                n[this.coordX][this.coordY] = new Immigration(this.getState() + 1, 0, this.coordX, this.coordY);
            }
        }else{
            n[this.coordX][this.coordY] = new Immigration(this.getState(), 0, this.coordX, this.coordY);
        }
    }

    /**
     * Method to set the state of a cellule to a random value between 0 and 3.
     */
    @Override
    void setStateRandom() {
        Random r = new Random();
        this.state = r.nextInt(4);
    }
    
}
