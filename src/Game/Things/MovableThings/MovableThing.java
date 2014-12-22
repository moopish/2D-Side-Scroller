package Game.Things.MovableThings;

import Game.Things.Thing;
import Game.Utilities.XYValue;

/**
 * Created by Michael on 21/12/2014.
 *
 */
public abstract class MovableThing extends Thing {

    private XYValue movement;

    public MovableThing() {
        super();
        movement = new XYValue(0,0);
    }

    public MovableThing(XYValue location) { this(location, new XYValue(0,0)); }

    public MovableThing(XYValue location, XYValue movement) {
        super(location);
        this.movement = new XYValue(movement);
    }

    public final XYValue getMovement() { return(movement); }

    public final void move() { setLocation(getX() + movement.getX(), getY() + movement.getY()); }

    public final void setMovement(XYValue movement) { this.movement.set(movement); }

    @Override
    public String toString() { return (super.toString() + "Movement :\n" + movement.toString()); }
}
