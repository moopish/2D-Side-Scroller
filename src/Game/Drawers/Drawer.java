package Game.Drawers;

import java.awt.*;

/**
 * Created by Michael on 05/12/2014.
 *
 *     The Drawer interface represents the structure that
 *  something must follow to be draw to screen. Each object
 *  that gets drawn to screen needs its own separate drawer
 *  object that implements the drawing
 *     T - is the class that the Drawer is handling
 *          e.g. StarDrawer implements Drawer<Stars>
 *
 */
public abstract interface Drawer<T> {

    public abstract void draw(T toDraw, Graphics2D g2d);

    public String getDrawerName();

}
