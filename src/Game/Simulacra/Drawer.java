package Game.Simulacra;

import Game.Things.Thing;

import java.awt.image.BufferedImage;

/**
 * Created by Michael on 05/12/2014.
 *
 *  Simulacrum interface (drawing(image of) interface)
 *     All drawing related classes must follow for drawing
 *
 */
public abstract interface Drawer {

    public abstract void draw(Thing toDraw, BufferedImage image);

}
