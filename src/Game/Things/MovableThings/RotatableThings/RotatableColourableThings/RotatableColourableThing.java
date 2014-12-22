package Game.Things.MovableThings.RotatableThings.RotatableColourableThings;

import Game.Drawers.Drawer;
import Game.Things.MovableThings.RotatableThings.RotatableThing;
import Game.Utilities.Angle;
import Game.Utilities.XYValue;

import java.awt.*;

/**
 * Created by Michael on 21/12/2014.
 */
public abstract class RotatableColourableThing extends RotatableThing {

    private Color colour;

    public RotatableColourableThing() {
        super();
        setColour(Color.WHITE);
    }

    public RotatableColourableThing(Drawer drawer, XYValue location, XYValue movement, Angle facingAngle, Color colour) {
        super(drawer, location, new XYValue(0, 0), facingAngle, new Angle(0));
        setColour(colour);
    }

    public RotatableColourableThing(Drawer drawer, XYValue location, XYValue movement, Angle facingAngle, Angle rotation, Color colour) {
        super(drawer, location, new XYValue(0, 0), facingAngle, rotation);
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
