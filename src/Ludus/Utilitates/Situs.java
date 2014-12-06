package Ludus.Utilitates;

/**
 * Created by Michael on 05/12/2014.
 *
 *  Situs Class (position/situation class)
 *      Relates to a x and y value
 */
public class Situs {

    private float x;
    private float y;

    public Situs()                  { this.set(0, 0); }
    public Situs(float x, float y)  { this.set(x, y); }
    public Situs(Situs copy)        { this.set(copy); }

    public float getX() { return (x); }
    public float getY() { return (y); }

    public void set(float x, float y) {
        setX(x);
        setY(y);
    }

    public void set(Situs copy) {
        setX(copy.x);
        setY(copy.y);
    }

    public void setX(float x) { this.x = x; }
    public void setY(float y) { this.y = y; }

    public String toString() { return ("x : " + x + "\ny : " + y); }
}
