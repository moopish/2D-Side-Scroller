package Ludus.Res;

import Ludus.Simulacra.Simulacrum;
import Ludus.Utilitates.Angulus;
import Ludus.Utilitates.Situs;

import java.awt.image.BufferedImage;

/**
 * Created by Michael on 04/12/2014.
 *
 * Res Class (Thing Class)
 */
public abstract class Res {

    private Simulacrum drawer;

    private Situs location;
    private Situs movement;

    protected Res() { init(); }

    protected Res(float xPosition, float yPosition, float xVelocity, float yVelocity, Simulacrum drawer){
        this(new Situs(xPosition, yPosition), new Situs(xVelocity, yVelocity), drawer);
    }

    protected Res(Situs location, float xVelocity, float yVelocity, Simulacrum drawer) {
        this(location, new Situs(xVelocity, yVelocity), drawer);
    }

    protected Res(float xPosition, float yPosition, Situs movement, Simulacrum drawer){
        this(new Situs(xPosition, yPosition), movement, drawer);
    }

    protected Res(Situs location, Situs movement, Simulacrum drawer) {
        this();
        setDrawer(drawer);
        setLocation(location);
        setMovement(movement);
    }

    protected Res(Res copy) {
        this();
        set(copy);
    }

    public final void draw(BufferedImage image) { drawer.draw(image);}

    public final Situs getLocation() { return (new Situs(location)); }
    public final Situs getMovement() { return (new Situs(movement)); }

    public final float getXLocation() { return (location.getX()); }
    public final float getYLocation() { return (location.getY()); }

    public final float getXMovement() { return (movement.getX()); }
    public final float getYMovement() { return (movement.getY()); }

    private void init() {
        location = new Situs();
        movement = new Situs();
    }

    public final void set(Res copy) {
        setDrawer(copy.drawer);
        setMovement(copy.movement);
        setLocation(copy.location);
    }

    public final void setDrawer(Simulacrum drawer) { this.drawer = drawer; }

    public final void setLocation(Situs location)   { this.location.set(location); }
    public final void setLocation(float x, float y) { this.location.set(x, y);     }

    public final void setMovement(Situs movement)   { this.movement.set(movement); }
    public final void setMovement(float x, float y) { this.movement.set(x, y);     }
    public final void setMovement(Angulus angle, float velocity) {
        this.movement.set(velocity*angle.cos(), velocity*angle.sin());
    }

}
