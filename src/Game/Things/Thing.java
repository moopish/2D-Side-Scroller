package Game.Things;

import Game.Simulacra.Drawer;
import Game.Utilities.Angle;
import Game.Utilities.XYValue;

import java.awt.image.BufferedImage;

/**
 * Created by Michael on 04/12/2014.
 *
 * Things Class (Thing Class)
 */
public abstract class Thing {

    private Drawer drawer;

    private XYValue location;
    private XYValue movement;

    protected Thing() { init(); }

    protected Thing(float xPosition, float yPosition, float xVelocity, float yVelocity, Drawer drawer){
        this(new XYValue(xPosition, yPosition), new XYValue(xVelocity, yVelocity), drawer);
    }

    protected Thing(XYValue location, float xVelocity, float yVelocity, Drawer drawer) {
        this(location, new XYValue(xVelocity, yVelocity), drawer);
    }

    protected Thing(float xPosition, float yPosition, XYValue movement, Drawer drawer){
        this(new XYValue(xPosition, yPosition), movement, drawer);
    }

    protected Thing(XYValue location, XYValue movement, Drawer drawer) {
        this();
        setDrawer(drawer);
        setLocation(location);
        setMovement(movement);
    }

    protected Thing(Thing copy) {
        this();
        set(copy);
    }

    public final void draw(BufferedImage image) { drawer.draw(this, image);}

    public final XYValue getLocation() { return (new XYValue(location)); }
    public final XYValue getMovement() { return (new XYValue(movement)); }

    public final float getXLocation() { return (location.getX()); }
    public final float getYLocation() { return (location.getY()); }

    public final float getXMovement() { return (movement.getX()); }
    public final float getYMovement() { return (movement.getY()); }

    private void init() {
        location = new XYValue();
        movement = new XYValue();
    }

    public final void set(Thing copy) {
        setDrawer(copy.drawer);
        setMovement(copy.movement);
        setLocation(copy.location);
    }

    public final void setDrawer(Drawer drawer) { this.drawer = drawer; }

    public final void setLocation(XYValue location)   { this.location.set(location); }
    public final void setLocation(float x, float y) { this.location.set(x, y);     }

    public final void setMovement(XYValue movement)   { this.movement.set(movement); }
    public final void setMovement(float x, float y) { this.movement.set(x, y);     }
    public final void setMovement(Angle angle, float velocity) {
        this.movement.set(velocity*angle.cos(), velocity*angle.sin());
    }

    public final void updateMovement() {
        updateMovementX();
        updateMovementY();
    }

    public final void updateMovementX() { location.setX(location.getX() + movement.getX()); }
    public final void updateMovementY() { location.setY(location.getY() + movement.getY()); }

}
