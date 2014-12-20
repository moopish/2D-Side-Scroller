package Ludus.Simulacra;

import Ludus.Res.Res;

import java.awt.image.BufferedImage;

/**
 * Created by Michael on 05/12/2014.
 *
 *  Simulacrum interface (drawing(image of) interface)
 *     All drawing related classes must follow for drawing
 *
 */
public abstract interface Simulacrum {

    public abstract void draw(Res toDraw, BufferedImage image);

}
