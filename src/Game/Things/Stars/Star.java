package Game.Things.Stars;

import Game.Simulacra.Drawer;
import Game.Simulacra.Stars.StarDrawer;
import Game.Things.Thing;
import Game.Utilities.XYValue;

import java.awt.*;

/**
 * Created by Michael on 04/12/2014.
 *
 */
public final class Star extends Thing {

    private static final float      SIZE_DIFF      = 0.25f;

    public static final Color       DEFAULT_COLOUR = new Color(255, 255, 255);
    public static final int         DEFAULT_SIZE   = 1;

    private static final Drawer MY_DRAWER      = new StarDrawer();

    private int     size   = DEFAULT_SIZE;    // determines draw size and depth (smaller farther away)
    private Color   colour;

    public Star() {
        super();
        setDrawer(MY_DRAWER);
    }

    public Star(float xPosition, float yPosition, float xVelocity, float yVelocity){
        this(xPosition, yPosition, xVelocity, yVelocity, DEFAULT_SIZE, DEFAULT_COLOUR);
    }

    public Star(float xPosition, float yPosition, float xVelocity, float yVelocity, int size, Color colour){
        this(new XYValue(xPosition, yPosition), new XYValue(xVelocity, yVelocity), size, colour);
    }

    public Star(XYValue location, float xVelocity, float yVelocity) {
        this(location, xVelocity, yVelocity, DEFAULT_SIZE, DEFAULT_COLOUR);
    }

    public Star(XYValue location, float xVelocity, float yVelocity, int size, Color colour) {
        this(location, new XYValue(xVelocity, yVelocity), size, colour);
    }

    public Star(float xPosition, float yPosition, XYValue movement){
        this(xPosition, yPosition, movement, DEFAULT_SIZE, DEFAULT_COLOUR);
    }

    public Star(float xPosition, float yPosition, XYValue movement, int size, Color colour){
        this(new XYValue(xPosition, yPosition), movement, size, colour);
    }

    public Star(XYValue location, XYValue movement) {
        this(location, movement, DEFAULT_SIZE, DEFAULT_COLOUR);
    }

    public Star(XYValue location, XYValue movement, int size, Color colour) {
        super(location, movement, MY_DRAWER);
        setColour(colour);
        setSize(size);
    }

    public Star(Star copy) {
        super(copy.getLocation(), copy.getMovement(), new StarDrawer());
    }

    public Color getColour()      { return (colour); }
    public int   getSize()        { return (size);   }
    public int   getSizeWithDif() { return ((int)Math.ceil(size * SIZE_DIFF)); }

    public void set(Star copy) {
        super.set(copy);
        setColour(copy.getColour());
    }

    public void setColour(int r, int g, int b) { this.colour = new Color(r, g, b); }
    public void setColour(Color colour)        { this.colour = new Color(colour.getRGB());  }

    public void setSize(int size) { this.size = (int)Math.ceil(size*SIZE_DIFF); }

}
