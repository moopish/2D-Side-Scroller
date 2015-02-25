package Game.Things.MovableThings.ColourableThings;

import Game.Things.MovableThings.MovableThing;
import Game.Utilities.XYValue;

import java.awt.*;

/**
 * Created by Michael on 21/12/2014.
 *
 * /////
 * //   The ColourableThing Class
 * ///////////////////////////
 *      //
 *      //     This class introduces colour to the
 *      //  MovableThing class allowing for similar
 *      //  Things to have different colour.
 *      //
 */
public abstract class ColourableThing extends MovableThing {

    private Color colour;

    public ColourableThing(XYValue location) {
        super(location, new XYValue(0, 0));
        setColour(Color.WHITE);
    }

    public ColourableThing(XYValue location, Color colour) {
        super(location, new XYValue(0, 0));
        setColour(colour);
    }

    public ColourableThing(XYValue location, XYValue movement, Color colour) {
        super(location, movement);
        setColour(colour);
    }

    public final Color getColour()             { return (colour);                                                    }
    public final void  setColour(Color colour) { this.colour = new Color(colour.getRGB(), colour.getAlpha() != 255); }

    @Override
    public String toString() {
        return (super.toString() + "Colour :\n" + "R : " + colour.getRed() + "\nG : " + colour.getGreen()
                + "\nB : " + colour.getBlue() + "\nAlpha : " + colour.getAlpha() + "\n");
    }

}
