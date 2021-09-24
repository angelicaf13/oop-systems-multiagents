/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

/**
 *
 * @author Angelica Figueroa Muñiz
 * Abstract class used to represent the grille of cells.
 */
public abstract class Grille {
    protected Cellule[][] grille;
    protected Cellule[][] newGrille;
    protected int dimension;
    
    /**
     * Constructor which takes as parameter the dimension for the height and
     * width of the grille.
     * @param d dimension of the height and width of the grille.
     */
    public Grille(int d){
        this.dimension = d;
        grille = new Cellule[d][d];
        newGrille = new Cellule[d][d];
    }
    
    /**
     * Method implemented in each one of the subclasses, utilized to fill
     * the grille with cells of a certain type.
     */
    public abstract void fillGrille();
    
    /**
     * Method implemented in each one of the subclasses, utilized to make the
     * changes in the grille, depending on the state of a cell and her,
     * neighbors. Each subclass will implemented this method differently, 
     * depending on the conditions and rules of the type of cell.
     */
    public abstract void updateGrille();
    
    /**
     * Method utilized to visualize the elements of the grille.
     * @return a String containing all the cells.
     */
    @Override
    public String toString(){
        String s = "";
        for (int j = 0; j < this.dimension; j++) {
            for (int i = 0; i < this.dimension; i++) {
                s += this.grille[i][j].toString();
            }
            s += "\n";
        }
        return s;
    }
}
