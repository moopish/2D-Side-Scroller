package Game.Things.MovableThings.ColourableThings;

import Game.Utilities.Angle;
import Game.Utilities.XYValue;

import java.awt.*;

/**
 * Created by Michael on 04/12/2014.
 *
 */
public final class Star extends ColourableThing {

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

    }

    public int getSize()         { return (size);                                  }
    public int getSizeWithDiff() { return ((int)Math.ceil(size * STAR_DIFF_SIZE)); }

    @Override
    public void update() {
        move();
    }
}
