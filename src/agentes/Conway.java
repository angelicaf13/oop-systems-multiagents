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
 * Class used to represent the cells of the Conway's Game of Life, extends
 * from the abstract class Cellule.
 */
public class Conway extends Cellule{
    
    public Conway(int state, int noNeighbors, int coordX, int coordY) {
        super(state, noNeighbors, coordX, coordY);
    }
    
    /**
     * Method to set the state of a cellule to a random value between 0 and 1.
     */
    @Override
    public void setStateRandom(){
        Random r = new Random();
        this.state = r.nextInt(2);
    }

    /**
     * Method for validating which will be the next state of a cellule, depending
     * on her current state and the value of the attribute noNeighbors. If the 
     * cell is dead, and has 3 exact neighbors alive, then in the new grille,
     * this cell will be alive, else, the cell will be dead in the new grille.
     * If the cell is alive and has exactly 2 or 3 alive neighbors, then in 
     * the new grille she keeps being alive if not, the cell is dead in the new
     * grille.
     * @param n a new Matrix where the modifications will be made.
     */
    @Override
    void validateNeighbors(Cellule[][] n) {
        if(this.state == 0){
            if(this.noNeighbors == 3){
                n[this.coordX][this.coordY] = new Conway(1, 0, coordX, coordY);
            }else{
                n[this.coordX][this.coordY] = new Conway(0, 0, coordX, coordY);
            }
        }else if(this.state == 1){
            if(this.noNeighbors == 2 || this.noNeighbors == 3){
                n[this.coordX][this.coordY] = new Conway(1, 0, coordX, coordY);
            }else{
                n[this.coordX][this.coordY] = new Conway(0, 0, coordX, coordY);
            }
        }
    }
    
}
