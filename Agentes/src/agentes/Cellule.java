/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

/**
 *
 * @author Angelica Figueroa Muñiz 
 * Abstract class used to represent a generic cell.
 */
public abstract class Cellule {

    protected int state;
    protected int noNeighbors;
    protected int coordX;
    protected int coordY;

    /**
     * Constructor that takes all the attributes as parameters
     * @param state
     * @param noNeighbors
     * @param coordX
     * @param coordY 
     */
    public Cellule(int state, int noNeighbors, int coordX, int coordY) {
        this.state = state;
        this.noNeighbors = noNeighbors;
        this.coordX = coordX;
        this.coordY = coordY;
    }
    

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getNoNeighbors() {
        return noNeighbors;
    }

    public void setNoNeighbors(int noNeighbors) {
        this.noNeighbors = noNeighbors;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    /**
     * 
     * @return returns a String with the state of the cellule
     */
    @Override
    public String toString() {
        return "" + state;
    }
    
    /**
     * Method to check the neighbors of the cellule situated in the upper 
     * left corner of the grille.
     * @param state all the neighbors state will be compared to this
     * @param w width of the grille
     * @param h height of the grille
     * @param c the matrix of cellules that represents the grille
     */
    public void checkUpperLeftCorner(int state, int w, int h, Cellule[][] c){
        this.noNeighbors = 0;
        if(c[w - 1][h - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX][h - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX + 1][h - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX + 1][this.coordY].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX + 1][this.coordY + 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX][this.coordY + 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[w - 1][this.coordY + 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[w - 1][this.coordY].getState() == state){
            this.noNeighbors += 1;
        }
    }

    /**
     * Method to check the neighbors of the cellule situated in the upper 
     * limit of the grille.
     * @param state all the neighbors state will be compared to this
     * @param w width of the grille
     * @param h height of the grille
     * @param c the matrix of cellules that represents the grille
     */
    public void checkUpperLimit(int state, int w, int h, Cellule[][] c){
        this.noNeighbors = 0;
        if(c[this.coordX - 1][h - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX][h - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX + 1][h - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX + 1][this.coordY].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX + 1][this.coordY + 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX][this.coordY + 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX - 1][this.coordY + 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX - 1][this.coordY].getState() == state){
            this.noNeighbors += 1;
        }
    }
    
    /**
     * Method to check the neighbors of the cellule situated in the upper 
     * right corner of the grille.
     * @param state all the neighbors state will be compared to this
     * @param w width of the grille
     * @param h height of the grille
     * @param c the matrix of cellules that represents the grille
     */
    public void checkUpperRightCorner(int state, int w, int h, Cellule[][] c){
        this.noNeighbors = 0;
        if(c[this.coordX - 1][h - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX][h - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[0][h- 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[0][this.coordY].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[0][this.coordY + 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX][this.coordY + 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX - 1][this.coordY + 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX - 1][this.coordY].getState() == state){
            this.noNeighbors += 1;
        }
    }
   
    /**
     * Method to check the neighbors of the cellules situated in the right
     * limit of the grille.
     * @param state all the neighbors state will be compared to this
     * @param w width of the grille
     * @param h height of the grille
     * @param c the matrix of cellules that represents the grille
     */
    public void checkRightLimit(int state, int w, int h, Cellule[][] c){
        this.noNeighbors = 0;
        if(c[this.coordX - 1][this.coordY - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX][this.coordY - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[0][this.coordY - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[0][this.coordY].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[0][this.coordY + 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX][this.coordY + 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX - 1][this.coordY + 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX - 1][this.coordY].getState() == state){
            this.noNeighbors += 1;
        }
    }
   
    /**
     * Method to check the neighbors of the cellule situated in the lower 
     * right corner of the grille.
     * @param state all the neighbors state will be compared to this
     * @param w width of the grille
     * @param h height of the grille
     * @param c the matrix of cellules that represents the grille
     */
    public void checkLowerRightCorner(int state, int w, int h, Cellule[][] c){
        this.noNeighbors = 0;
        if(c[this.coordX - 1][this.coordY - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX][this.coordY - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[0][this.coordY - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[0][this.coordY].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[0][0].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX][0].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX - 1][0].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX - 1][this.coordY].getState() == state){
            this.noNeighbors += 1;
        }
    }

    /**
     * Method to check the neighbors of the cellules situated in the lower
     * limit of the grille.
     * @param state all the neighbors state will be compared to this
     * @param w width of the grille
     * @param h height of the grille
     * @param c the matrix of cellules that represents the grille
     */
    public void checkLowerLimit(int state, int w, int h, Cellule[][] c){
        this.noNeighbors = 0;
        if(c[this.coordX - 1][this.coordY - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX][this.coordY - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX + 1][this.coordY - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX + 1][this.coordY].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX + 1][0].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX][0].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX - 1][0].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX - 1][this.coordY].getState() == state){
            this.noNeighbors += 1;
        }
    }
   
    /**
     * Method to check the neighbors of the cellule situated in the lower 
     * left corner of the grille.
     * @param state all the neighbors state will be compared to this
     * @param w width of the grille
     * @param h height of the grille
     * @param c the matrix of cellules that represents the grille
     */
    public void checkLowerLeftCorner(int state, int w, int h, Cellule[][] c){
        this.noNeighbors = 0;
        if(c[w - 1][this.coordY - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX][this.coordY - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX + 1][this.coordY - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX + 1][this.coordY].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX + 1][0].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX][0].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[w - 1][0].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[w - 1][this.coordY].getState() == state){
            this.noNeighbors += 1;
        }
    }
 
    /**
     * Method to check the neighbors of the cellules situated in the left
     * limit of the grille.
     * @param state all the neighbors state will be compared to this
     * @param w width of the grille
     * @param h height of the grille
     * @param c the matrix of cellules that represents the grille
     */
    public void checkLeftLimit(int state, int w, int h, Cellule[][] c){
        this.noNeighbors = 0;
        if(c[w - 1][this.coordY - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX][this.coordY - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX + 1][this.coordY - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX + 1][this.coordY].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX + 1][this.coordY + 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX][this.coordY + 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[w - 1][this.coordY + 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[w - 1][this.coordY].getState() == state){
            this.noNeighbors += 1;
        }
    }
    
    /**
     * Method to check the state of the neighbors for the cellules situated in
     * the middle and whose neighbors aren't situated outside the limits of the
     * grille. For each neighbor, we compare it's state and the state sent to 
     * the method, if the states are the same, the attribute noNeighbors is 
     * increased by one, counting the neighbors that have the same state as the
     * one received in the method.
     * @param state all the neighbors state will be compared to this
     * @param c the matrix of cellules that represents the grille
     */
    public void checkMiddle(int state, Cellule[][] c){
        this.noNeighbors = 0;
        if(c[this.coordX + 1][this.coordY + 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX + 1][this.coordY].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX + 1][this.coordY - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX][this.coordY - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX - 1][this.coordY - 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX - 1][this.coordY].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX - 1][this.coordY + 1].getState() == state){
            this.noNeighbors += 1;
        }
        if(c[this.coordX - 1][this.coordY + 1].getState() == state){
            this.noNeighbors += 1;
        }
    }
  
    /**
     * Method used to check the coordinates of a cellule, and according to them, 
     * the proper method to check her neighbors is used, after the counting of
     * the neighbors is done, the method validateNeighbors is called.
     * @param state
     * @param width
     * @param height
     * @param c
     * @param n 
     */
    public void checkNeighbors(int state, int width, int height, Cellule[][] c, Cellule[][] n){
        if(this.coordX == width - 1 && this.coordY == 0){
            checkUpperRightCorner(state, width, height, c);
            validateNeighbors(n);
        }else if(this.coordX > 0 && this.coordX < width && this.coordY == 0){
            checkUpperLimit(state, width, height, c);
            validateNeighbors(n);
        }else if(this.coordX == 0 && this.coordY == 0){
            checkUpperLeftCorner(state, width, height, c);
            validateNeighbors(n);
        }else if(this.coordX == width - 1 && this.coordY > 0 && this.coordY < height - 1){
            checkRightLimit(state, width, height, c);
            validateNeighbors(n);
        }else if(this.coordX == width - 1 && this.coordY == height -1){
            checkLowerRightCorner(state, width, height, c);
            validateNeighbors(n);
        }else if(this.coordX > 0 && this.coordX < width - 1 && this.coordY == height - 1){
            checkLowerLimit(state, width, height, c);
            validateNeighbors(n);
        }else if(this.coordX == 0 && this.coordY > 0 && this.coordY < height - 1){
            checkLeftLimit(state, width, height, c);
            validateNeighbors(n);
        }else if(this.coordX == 0 && this.coordY == height - 1){
            checkLowerLeftCorner(state, width, height, c);
            validateNeighbors(n);
        }else{
            checkMiddle(state, c);
            validateNeighbors(n);
        }
    }
    
    /**
     * This method will be implemented in each subclass, it will include the 
     * conditions and clauses needed to achieve the correct performance of each
     * type of cellule (conway, immigration, schelling, etc).
     * @param n the matrix of cellules that represents the grille
     */
    abstract void validateNeighbors(Cellule[][] n);
    
    /**
     * Method implemented in each of the subclasses to set the state of a 
     * cellule to a random value, this value being chosen depending on the
     * type of the cellule.
     */
    abstract void setStateRandom();
    
}
