package agentes;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Classe représentant un ensemble de Boids
 *
 * @author Equipe 59
 */
public class Flock {

    private ArrayList<Boid> boids; 
    private Color color; 

    /**
     * Constructeur de classe
     *
     * @param boids Ensemble de Boids
     * @param color Couleur du Flock
     */
    public Flock(ArrayList boids, Color color) {
        this.boids = boids;
        this.color = color;
    }

     /**
     * Méthode de mise à jour de la position des boids, chaque boid doit
     * connaître les informations des autres boids.
     *
     */
    public void run() {
        for (Boid b : getBoids()) {
            b.run(getBoids());
        }
    }

     /**
     * Méthode pour ajouter un boid au Flock.
     *
     * @param b Le Boid à ajouter
     */
    public void addBoid(Boid b) {
        getBoids().add(b);
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return the boids
     */
    public ArrayList<Boid> getBoids() {
        return boids;
    }
}
