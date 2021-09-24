package agentes;

import gui.GUISimulator;
import java.util.ArrayList;

/**
 * Classe représentant un boid qui s'éloigne du centre de masse
 * @author Equipe 59
 */
public class BoidBreak extends Boid {

    /**
     * Constructeur de classe, prenez les valeurs de la classe mère. 
     * 
     * @param coordX Emplacement, coordonnée X
     * @param coordY Emplacement, coordonnée Y
     * @param gui Interface où le Boid sera ajouté
     */
    public BoidBreak(float coordX, float coordY, GUISimulator gui) {
        super(coordX, coordY, gui);
    }

    /**
     * Override du méthode flock() de la classe Boid, où on donne une 
     * valeur négative à la cohésion. 
     */ 
    @Override
    void flock(ArrayList<Boid> boids) {
        PVector sep = separate(boids);   // Separation
        PVector ali = align(boids);      // Alignment
        PVector coh = cohesion(boids);   // Cohesion
        // Arbitrarily weight these forces
        sep.mult(1.5f);
        ali.mult(1.0f);
        coh.mult(-1.0f);
        // Add the force vectors to acceleration
        applyForce(sep);
        applyForce(ali);
        applyForce(coh);
    }
}
