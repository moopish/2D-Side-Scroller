package Game.Things.AreaThings;

import Game.Things.Thing;
import Game.Utilities.Util;
import Game.Utilities.XYValue;

/**
 * Created by Michael on 21/12/2014.
 */
public abstract class AreaThing extends Thing {

    private XYValue dimensions;

    public AreaThing(XYValue location, XYValue dimensions) {
        super(location);
        this.dimensions = new XYValue(dimensions);
    }

    public XYValue getDimensions() { return (dimensions); }

    public boolean isInside(XYValue point) {
        return (Util.inRange(point.getX(), getX(), getX() + dimensions.getX()) &&
                Util.inRange(point.getY(), getY(), getY() + dimensions.getY()));
    }

    public boolean isOutside(XYValue point) { return (!isInside(point)); }

    public float randomX() { return ((float)(Math.random() * dimensions.getX() + getX())); }
    public float randomY() { return ((float)(Math.random() * dimensions.getY() + getY())); }

    public XYValue randomLocation() { return (new XYValue(randomX(), randomY())); }

}
