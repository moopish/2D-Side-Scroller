package Game.Areas;

import Game.Utilities.Angle;
import Game.Utilities.XYValue;

/**
 * Created by Michael on 08/12/2014.
 *
 */
public class Area {

    private XYValue[] points;

    public Area(XYValue p1, XYValue p2, XYValue p3) {
        this.points = new XYValue[3];
        this.points[0] = new XYValue(p1);
        this.points[1] = new XYValue(p2);
        this.points[2] = new XYValue(p3);
    }

    public Area(XYValue[] points) {
        // TODO handle the potential errors
    }

    public boolean isInside(XYValue point) {
        // TODO FINISH
        int j;
        Angle ai, aj;

        for (int i = 0; i < 3; ++i) {
            j = (i + 1) % 3;
        }

        return (true);
    }

    public static void main(String args[]) {

    }

}
