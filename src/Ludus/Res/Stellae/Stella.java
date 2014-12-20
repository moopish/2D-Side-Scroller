package Ludus.Res.Stellae;

import Ludus.Res.Res;
import Ludus.Simulacra.Simulacrum;
import Ludus.Simulacra.Stellae.SimulacrumStellae;
import Ludus.Utilitates.Color;
import Ludus.Utilitates.Situs;

/**
 * Created by Michael on 04/12/2014.
 *
 */
public final class Stella extends Res{

    private static final float      SIZE_DIFF      = 0.25f;

    public static final Color       DEFAULT_COLOUR = new Color(255, 255, 255);
    public static final int         DEFAULT_SIZE   = 1;

    private static final Simulacrum MY_DRAWER      = new SimulacrumStellae();

    private int     size   = DEFAULT_SIZE;    // determines draw size and depth (smaller farther away)
    private Color   colour = DEFAULT_COLOUR;

    public Stella() {
        super();
        setDrawer(MY_DRAWER);
    }

    public Stella(float xPosition, float yPosition, float xVelocity, float yVelocity){
        this(xPosition, yPosition, xVelocity, yVelocity, DEFAULT_SIZE, DEFAULT_COLOUR);
    }

    public Stella(float xPosition, float yPosition, float xVelocity, float yVelocity, int size, Color colour){
        this(new Situs(xPosition, yPosition), new Situs(xVelocity, yVelocity), size, colour);
    }

    public Stella(Situs location, float xVelocity, float yVelocity) {
        this(location, xVelocity, yVelocity, DEFAULT_SIZE, DEFAULT_COLOUR);
    }

    public Stella(Situs location, float xVelocity, float yVelocity, int size, Color colour) {
        this(location, new Situs(xVelocity, yVelocity), size, colour);
    }

    public Stella(float xPosition, float yPosition, Situs movement){
        this(xPosition, yPosition, movement, DEFAULT_SIZE, DEFAULT_COLOUR);
    }

    public Stella(float xPosition, float yPosition, Situs movement, int size, Color colour){
        this(new Situs(xPosition, yPosition), movement, size, colour);
    }

    public Stella(Situs location, Situs movement) {
        this(location, movement, DEFAULT_SIZE, DEFAULT_COLOUR);
    }

    public Stella(Situs location, Situs movement, int size, Color colour) {
        super(location, movement, MY_DRAWER);
        setColour(colour);
        setSize(size);
    }

    public Stella(Stella copy) {
        super(copy.getLocation(), copy.getMovement(), new SimulacrumStellae());
    }

    public Color getColour() { return (colour); }
    public int   getSize()   { return (size);   }

    public void set(Stella copy) {
        super.set(copy);
        setColour(copy.getColour());
    }

    public void setColour(int r, int g, int b) { this.colour.set(r, g, b); }
    public void setColour(Color colour)        { this.colour.set(colour);  }

    public void setSize(int size) { this.size = (int)Math.ceil(size*SIZE_DIFF); }

}
