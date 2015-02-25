package Game.Things.MovableThings.ColourableThings;

import Game.Utilities.Angle;
import Game.Utilities.XYValue;

import java.awt.*;

/**
 * /////
 * //   The Star Class
 * //       Author : Michael van Dyk
 * //      Created : 04/12/2014
 * ///////////////////////////
 *      //
 *      //     This concrete class is used to represent a
 *      //  star. Unique to this class is a size attribute
 *      //  which is used to create a distance effect in
 *      //  the LayeredStarField class. Movement of a star
 *      //  is determined with the direction of an angle and
 *      //  magnitude is determined with the size.
 *      //
 */
public final class Star extends ColourableThing {

    public final static Color[] STAR_COLOURS = { new Color(255, 107, 52),
                                                 new Color(255, 168, 115),
                                                 new Color(255, 216, 185),
                                                 new Color(255, 255, 255),
                                                 new Color(204, 228, 255),
                                                 new Color(172, 210, 255),
                                                 new Color(138, 188, 255),
                                                 new Color(91, 151, 255),
                                                 new Color(81, 144, 255)   };

    private final static float        STAR_DIFF_SIZE  = 0.25f;

    private int size;

    public Star()                                         { this(1);                                                       }
    public Star(int size)                                 { this(new XYValue(0, 0), size);                                 }
    public Star(XYValue location, int size)               { this(location, Color.WHITE, size);                             }
    public Star(XYValue location, Color colour, int size) { this(location, new Angle((float)(3*Math.PI/2)), colour, size); }

    public Star(XYValue location, Angle movement, Color colour, int size) {
        super(location, new XYValue(size * STAR_DIFF_SIZE * movement.cos(),
                size * STAR_DIFF_SIZE * movement.sin()), colour);
        this.size = size;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setPaint(getColour());
        g2d.fillRect((int)getX(), (int)getY(), getSizeWithDiff(), getSizeWithDiff());
    }

    public int getSize()         { return (size);                                  }
    public int getSizeWithDiff() { return ((int)Math.ceil(size * STAR_DIFF_SIZE)); }

    @Override
    public void update() {
        move();
    }
}
