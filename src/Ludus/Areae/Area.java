package Ludus.Areae;

import Ludus.Utilitates.Angulus;
import Ludus.Utilitates.Situs;

/**
 * Created by Michael on 08/12/2014.
 *
 */
public class Area {

    private Situs[] points;

    public Area(Situs p1, Situs p2, Situs p3) {
        this.points = new Situs[3];
        this.points[0] = new Situs(p1);
        this.points[1] = new Situs(p2);
        this.points[2] = new Situs(p3);
    }

    public Area(Situs[] points) {
        // TODO handle the potential errors
    }

    public boolean isInside(Situs point) {
        int j;
        Angulus ai, aj;

        for (int i = 0; i < 3; ++i) {
            j = (i + 1) % 3;
        }

        return (true);
    }

    public static void main(String args[]) {

    }

}
