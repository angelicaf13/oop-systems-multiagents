/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

/**
 *
 * @author Angelica Figueroa Muñiz
 */
public class ConwayGrille extends Grille{

    public ConwayGrille(int d) {
        super(d);
    }

    /**
     * Method used for filling the matrix with Conway objects. Once the Conway
     * object is inserted, his state is set to a random value between 0 and 1.
     */
    @Override
    public void fillGrille() {
        for (int j = 0; j < this.dimension; j++) {
            for (int i = 0; i < this.dimension; i++) {
                this.grille[i][j] = new Conway(0, 0, i, j);
                this.grille[i][j].setStateRandom();
            }
        }
    }

    /**
     * Method for updating the state of each one of the Conway cellules inside
     * the matrix.
     */
    @Override
    public void updateGrille() {
        for (int j = 0; j < this.dimension; j++) {
            for (int i = 0; i < this.dimension; i++) {
                this.grille[i][j].checkNeighbors(1, this.dimension, this.dimension, this.grille, this.newGrille);
            }
        }
        grille = newGrille;
    }

    
}
