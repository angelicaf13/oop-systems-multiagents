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
public class ImmigrationEvent extends Event{
    private ImmigrationSimulator i;

    public ImmigrationEvent(int date, ImmigrationSimulator i) {
        super(date);
        this.i = i;
    }

    @Override
    public void execute() {
        i.getImmigration().updateGrille();
        i.addElements();
        i.getManager().add(new ImmigrationEvent(super.getDate() + 1, i));
    }
    
}
