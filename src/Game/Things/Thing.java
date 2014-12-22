package Game.Things;

import Game.Utilities.XYValue;

import java.awt.*;

/**
 * Created by Michael on 21/12/2014.
 *
 * /////
 * //   The Thing Class
 * ////////////////////
 *      //
 *      //     The Thing class is the base for all object used. It contains
 *      //   an ID, which will be used to store in an Thing list. All Things
 *      //   are drawable and thus holds a Drawer for drawing. Things also
 *      //   have a location, but not all are movable (thus no movement here).
 *      //
 *      //   TODO add object list to track Things
 */

public abstract class Thing {

    private static long      newID = 0;

    private final long       ID;

    private XYValue          location;

    public Thing() {
        ID = newID;
        ++newID;
        location = new XYValue(0,0);
    }

    public Thing(XYValue location) {
        this();
        setLocation(location);
    }

    public abstract void draw(Graphics2D g2d);

    public final long       getID       ()      { return (ID);              }
    public final XYValue    getLocation ()      { return (location);        }
    public final float      getX        ()      { return (location.getX()); }
    public final float      getY        ()      { return (location.getY()); }

    public final void setLocation (XYValue location)  { this.location.set(location); }
    public final void setLocation (float x, float y)  { this.location.set(x, y);     }
    public final void setX        (float x)           { this.location.setX(x);       }
    public final void setY        (float y)           { this.location.setY(y);       }

    @Override
    public String toString() {
        return ("ID : " + ID + "\nLocation :\n" + location.toString());
    }

    public abstract void update();
}
