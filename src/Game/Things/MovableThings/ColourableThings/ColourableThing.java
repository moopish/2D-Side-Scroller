package Game.Things.MovableThings.ColourableThings;

import Game.Drawers.Drawer;
import Game.Things.MovableThings.MovableThing;
import Game.Utilities.XYValue;

import java.awt.*;

/**
 * Created by Michael on 21/12/2014.
 *
 */
public abstract class ColourableThing extends MovableThing {

    private Color colour;

    public ColourableThing(Drawer drawer, XYValue location) {
        super(drawer, location, new XYValue(0, 0));
        setColour(Color.WHITE);
    }

    public ColourableThing(Drawer drawer, XYValue location, Color colour) {
        super(drawer, location, new XYValue(0, 0));
        setColour(colour);
    }

    public ColourableThing(Drawer drawer, XYValue location, XYValue movement, Color colour) {
        super(drawer, location, movement);
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