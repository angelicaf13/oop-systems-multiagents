package agentes;

import gui.GUISimulator;
import gui.Rectangle;
import gui.Simulable;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 *
 * @author Equipe 59
 */
public class FlockSimulator extends GUISimulator implements Simulable {

    private ArrayList<Flock> flocks; //Les flocks établis dans cette simulation

    /**
     * Constructeur de la classe qui prend les attributs de sa mère et crée 
     * les flocks qui vont être simulés, en ajoutant à chacun les Boids
     * nécessaires.
     * 
     */
    public FlockSimulator() {
        super(500, 500, Color.WHITE);
        flocks = new ArrayList();

        //Création de flock avec des Boids normaux
        Flock flock = new Flock(new ArrayList<>(), Color.BLUE);
        flocks.add(flock);
        for (int i = 0; i < 100; i++) {
            Boid b = new Boid(getPanelWidth() / 2, getPanelHeight() / 2, this);
            flocks.get(0).addBoid(b);
        }

        //Création de flock avec des Boids qui s'éloignent du centre de masse
        Flock flockBreak = new Flock(new ArrayList<>(), Color.GREEN);
        flocks.add(flockBreak);
        for (int j = 0; j < 80; j++) {
            BoidBreak b = new BoidBreak(getPanelWidth() / 2, getPanelHeight() / 2, this);
            flocks.get(1).addBoid(b);
        }

        //Création de flock avec des Boids limités à un espace défini
        Flock flockBound = new Flock(new ArrayList<>(), Color.RED);
        flocks.add(flockBound);
        for (int j = 0; j < 50; j++) {
            BoidBounding b = new BoidBounding(getPanelWidth() / 2, getPanelHeight() / 2, this);
            flocks.get(2).addBoid(b);
        }
    }

    /**
     *  Méthode qui exécute la méthode run() de chaque Boid 
     *  de chaque Flock à simuler.
     */
    public void runFlocks() {
        for (int i = 0; i < flocks.size(); i++) {
            flocks.get(i).run();
        }
    }

    /**
     * Méthode qui ajoute graphiquement les Boids à l'interface.
     * 
     */
    public void addElements() {
        for (int i = 0; i < flocks.size(); i++) {
            for (int j = 0; j < flocks.get(i).getBoids().size(); j++) {
                addGraphicalElement(new Rectangle(
                        (int) flocks.get(i).getBoids().get(j).getLocation().getX(),
                        (int) flocks.get(i).getBoids().get(j).getLocation().getY(),
                        flocks.get(i).getColor(),
                        flocks.get(i).getColor(),
                        flocks.get(i).getBoids().get(j).getSize(),
                        flocks.get(i).getBoids().get(j).getSize()));
            }
            flocks.get(i).run();
        }
    }

    /**
     * Méthode exécutée en appuyant sur le bouton Next.
     * 
     */
    @Override
    public void next() {

        manager.add(new FlockEvent(0, this));
        super.timer = new Timer((int) super.speedSpinner.getValue(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                manager.next();
            }
        });
        timer.start();
    }

    @Override
    public void restart() {

    }
}
