package agentes;

/**
 *
 * @author Equipe 59
 */
public class FlockEvent extends Event {

    private FlockSimulator s;

    public FlockEvent(int date, FlockSimulator s) {
        super(date);
        this.s = s;
    }

    @Override
    public void execute() {
        s.runFlocks();
        s.reset();
        s.addElements();
        s.getManager().add(new FlockEvent(super.getDate() + 1, s));
    }
}
