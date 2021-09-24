package agentes;

import gui.GUISimulator;
import java.util.ArrayList;

/**
 * Classe qui représente un boid avec des limites d'espace dans lequel peut se déplacer.
 * @author Equipe 59
 */
public class BoidBounding extends Boid {

    /**
     * Constructeur de classe, prenez les valeurs de la classe mère. 
     * 
     * @param coordX Emplacement, coordonnée X
     * @param coordY Emplacement, coordonnée Y
     * @param gui Interface où le Boid sera ajouté
     */
    public BoidBounding(float coordX, float coordY, GUISimulator gui) {
        super(coordX, coordY, gui);
    }

    /**
     * Méthode qui implémente une règle qui encourage les boids à rester 
     * dans les limites définies.
     * 
     * @return Le vecteur de force qui sera appliqué au boid pour se conformer à la règle
     */
    public PVector bound_position() {

        int Xmin = 100, Xmax = 400, Ymin = 100, Ymax = 400;
        PVector vector = new PVector(0, 0);

        if (this.getLocation().getX() < Xmin) {
            vector.setX(10);
        } else if (this.getLocation().getX() > Xmax) {
            vector.setX(-10);
        }

        if (this.getLocation().getY() < Ymin) {
            vector.setY(10);
        } else if (this.getLocation().getY() > Ymax) {
            vector.setY(-10);
        }

        return vector;
    }

    /**
     * Override du méthode flock() de la classe Boid, où la force obtenue à 
     * partir du méthode bound_position() est appliquée.   
     */  
    @Override
    void flock(ArrayList<Boid> boids) {
        PVector sep = separate(boids);   // Separation
        PVector ali = align(boids);      // Alignment
        PVector coh = cohesion(boids);   // Cohesion
        // Arbitrarily weight these forces
        sep.mult(1.5f);
        ali.mult(1.0f);
        coh.mult(1.5f);
        // Add the force vectors to acceleration
        applyForce(sep);
        applyForce(ali);
        applyForce(coh);
        applyForce(bound_position());
    }
}
