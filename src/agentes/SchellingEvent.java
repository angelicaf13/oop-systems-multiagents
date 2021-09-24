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
public class SchellingEvent extends Event{
    private SchellingSimulator s;

    public SchellingEvent(int date, SchellingSimulator s) {
        super(date);
        this.s = s;
    }

    @Override
    public void execute() {
        s.getSchelling().updateGrille();
        s.addElements();
        s.getManager().add(new SchellingEvent(super.getDate() + 1, s));
    }
    
}
