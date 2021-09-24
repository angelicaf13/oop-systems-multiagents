/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Angelica Figueroa Muñiz
 * Class used to represent the cells of the Schelling model, extends
 * from the abstract class Cellule.
 */
public class Schelling extends Cellule{
    private int color;
    private static int k = 3;
    private static final int N_COLORS = 2;
    private static ArrayList <Schelling> vacantes = new ArrayList();

    public Schelling(int state, int noNeighbors, int coordX, int coordY, int color) {
        super(state, noNeighbors, coordX, coordY);
        this.color = color;
    }

    public static ArrayList<Schelling> getVacantes() {
        return vacantes;
    }

    public static int getN_COLORS() {
        return N_COLORS;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
    
    
    /**
     * Method used for changing a family's habitation.
     * 
     * @param n the matrix that represents the grille
     */
    public void demenage(Cellule[][] n) {
        int newX, newY;
        Collections.shuffle(vacantes);//The order of the arraylist vacantes is mixed.
        
        newX = vacantes.get(0).coordX;
        newY = vacantes.get(0).coordY;
        //System.out.println(this.coordX + "," + this.coordY + " " + this.color + "  " + newX + "," + newY);
        
        n[newX][newY] = this; //The family gets assigned to the first vacante habitation in the ArrayList
        n[this.coordX][this.coordY] = new Schelling(0, 0, this.coordX, this.coordY, -1); //The old habitation state is set to vacant
        vacantes.add(new Schelling(0, 0, this.coordX, this.coordY, -1)); //The old habitation is added to the arraylist of vacant rooms
        //the coordinates of the family are updated to the ones of the new room
        this.coordX = newX; 
        this.coordY = newY;

        //n[vacantes.get(0).coordX][vacantes.get(0).coordY].coordX = vacantes.get(0).coordX;
        //n[vacantes.get(0).coordX][vacantes.get(0).coordY].coordY = vacantes.get(0).coordY;
        vacantes.remove(0); //Once the habitation is assigned to a family, it gets removed from the ArrayList

    }
    
    /**
     * Method to set the state of the cell to a random value between 0 and 1, 
     * to indicate if a room is occupied or vacant.
     */
    @Override
    void setStateRandom() {
        Random r = new Random();
        this.state = r.nextInt(2);
    }
    
    /**
     * Method to set the color of a family to a random value.
     */
    public void setColorRandom(){
        Random r = new Random();
        this.color = r.nextInt(N_COLORS);
    }

    /**
     * Method utilized to validate if a family has to change rooms.
     * @param n the matrix that represents the grille.
     */
    @Override
    void validateNeighbors(Cellule[][] n) {
        if(8 - this.noNeighbors >  k && this.color > -1){ //If the number of neighborhs with a different color is bigger than K
            //This habitation is now vacante
            demenage(n); //The family changes from habitation
            //vacantes.add(this); //The habitation is added to the vacantes ArrayList
        }else{
            n[this.coordX][this.coordY] = new Schelling(this.state, this.color, this.coordX, this.coordY, this.color);
        }
    }
    
}
