package Game.Things.AreaThings.CollectiveThings;

import Game.Things.MovableThings.ColourableThings.Star;
import Game.Utilities.Angle;
import Game.Utilities.Util;
import Game.Utilities.XYValue;

import java.awt.*;

/**
 * Created by Michael on 04/12/2014.
 *
 */
public final class StarField extends StaticCollectiveThing<Star> {

    private static final int    OFF_SCREEN_DIST = 25;

    private Angle   movement;
    private int     starSize;
    private boolean colourful;

    public StarField(XYValue dimensions, int count, int starSize, Angle movement, boolean colourful) {
        super(new XYValue(-OFF_SCREEN_DIST, -OFF_SCREEN_DIST),
              new XYValue(dimensions.getX() + OFF_SCREEN_DIST*2, dimensions.getY() + OFF_SCREEN_DIST*2), count);
        this.movement = new Angle(movement);
        this.starSize = starSize;
        this.colourful = colourful;
        setup();
    }

    private void setup() {
        Color starColour = Color.WHITE;

        for (int i=0; i<getCount(); ++i) {
            if (colourful) {
                starColour = new Color(Util.randIntRange(255),
                                       Util.randIntRange(255),
                                       Util.randIntRange(255));
            }

            set(new Star(randomLocation(), movement, starColour, starSize), i);
        }
    }

    @Override
    public void update() {
        super.update();
        for (int i=0; i<getCount(); ++i) {
            if (isOutside(get(i).getLocation())) {
                Color starColour = Color.WHITE;

                if (colourful) {
                    starColour = new Color(Util.randIntRange(255),
                            Util.randIntRange(255),
                            Util.randIntRange(255));
                }

                int x, y;
                if (Util.randBool()) {
                    x = (int)((Math.random() * OFF_SCREEN_DIST));

                    if (Util.randBool())
                        x = -x;
                    else
                        x += getDimensions().getX() - OFF_SCREEN_DIST * 2;

                    y = (int)randomY();
                } else {
                    y = (int) ((Math.random() * OFF_SCREEN_DIST));

                    if (Util.randBool())
                        y = -y;
                    else
                        y += getDimensions().getY() - OFF_SCREEN_DIST * 2;

                    x = (int)randomX();
                }

                get(i).setColour(starColour);
                get(i).setLocation(x, y);
            }
        }
    }
}
