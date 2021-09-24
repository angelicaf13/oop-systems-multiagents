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
public class ImmigrationGrille extends Grille{

    public ImmigrationGrille(int d) {
        super(d);
    }

    @Override
    public void fillGrille() {
        for (int j = 0; j < this.dimension; j++) {
            for (int i = 0; i < this.dimension; i++) {
                this.grille[i][j] = new Immigration(0, 0, i, j);
                this.grille[i][j].setStateRandom();
            }
        }
    }

    @Override
    public void updateGrille() {
        for (int j = 0; j < this.dimension; j++) {
            for (int i = 0; i < this.dimension; i++) {
                if(this.grille[i][j].state == 3){
                    this.grille[i][j].checkNeighbors(0, this.dimension, this.dimension, this.grille, this.newGrille);
                }else{
                    this.grille[i][j].checkNeighbors(this.grille[i][j].getState() + 1, this.dimension, this.dimension, this.grille, this.newGrille);
                }
            }
        }
        grille = newGrille;
    }

}
