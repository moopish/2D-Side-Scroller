package Game.Simulacra.Stars;

import Game.Simulacra.Drawer;
import Game.Things.Thing;
import Game.Things.Stars.Star;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Michael on 05/12/2014.
 *
 *  SimulacrumStellae class (image of star class)
 *      Draw class for a star object
 *
 */
public final class StarDrawer implements Drawer {

    public void draw (Thing toDraw, BufferedImage image) {
        Graphics2D g2d = image.createGraphics();

        Star star = (Star)toDraw;
        g2d.setPaint(star.getColour());
        g2d.fillRect((int) star.getXLocation(), (int) star.getYLocation(), star.getSizeWithDif(), star.getSizeWithDif());
    }

}
