package Ludus.Utilitates;

/**
 * Created by Michael on 05/12/2014.
 *
 *  Situs Class (position/situation class)
 *      Relates to a x and y value
 *
 *      This class represents a 2D value, like a point or a vector
 */
public class Situs {

    /////
    //   The values of the point/vector
    private float x;
    private float y;

    /////
    //   Constructors
    public Situs()                  { this.set(0, 0); }
    public Situs(float x, float y)  { this.set(x, y); }
    public Situs(Situs copy)        { this.set(copy); }

    // TODO test
    public static float distance(Situs a, Situs b) { return ((float)Math.sqrt((b.getX() - a.getX()) + (b.getY() - a.getY()))); }
    public float distance(Situs other) { return (distance(this, other)); }

    /////
    //   Getter functions for x and y
    public final float getX() { return (x); }
    public final float getY() { return (y); }

    /////
    //   Sets the Situs based on given x and y
    public void set(float x, float y) {
        setX(x);
        setY(y);
    }

    /////
    //   Makes the Situs have the same values as the given Situs
    public void set(Situs copy) {
        setX(copy.x);
        setY(copy.y);
    }

    /////
    //   Setters for x and y
    public final void setX(float x) { this.x = x; }
    public final void setY(float y) { this.y = y; }

    public String toString() { return ("x : " + x + "\ny : " + y); }
}
