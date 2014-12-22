package Game.Things.AreaThings.CollectiveThings;

import Game.Utilities.Angle;
import Game.Utilities.XYValue;

import java.awt.*;

/**
 * Created by Michael on 21/12/2014.
 *
 */
public final class LayeredStarField extends StaticCollectiveThing<StarField> {

    public LayeredStarField(XYValue dimensions, int starCount, int layerCount, Angle movement) {
        this(dimensions, starCount, layerCount, movement, false);
    }

    public LayeredStarField(XYValue dimensions, int starCount, int layerCount, Angle movement, boolean colourful) {
        super(new XYValue(0, 0), dimensions, layerCount);

        for (int i=0; i<getCount(); ++i)
            set(new StarField(dimensions, starCount, i+1, movement, colourful), i);
    }

    @Override
    public void draw(Graphics2D g2d) {
        for (int i=0; i<getCount(); ++i)
            get(i).draw(g2d);
    }

    @Override
    public String toString() {
        return (super.toString() + "Layers : " + getCount() + "\n");
    }
}
