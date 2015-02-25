package Game.Things;

import Game.Utilities.XYValue;

import java.awt.*;

/**
 *
 * /////
 * //   The Thing Class
 * //       Author : Michael van Dyk
 * //      Created : 21/12/2014
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

    private static long      newID = 0; //Used to give unique identifying value to each Thing

    private final long       ID;        //The identifying value, for Thing tracking

    private XYValue          location;  //The location of the Thing

    public Thing() {
        ID = newID;
        ++newID;
        location = new XYValue(0,0);
    }

    public Thing(XYValue location) {
        this();
        setLocation(location);
    }

    /////
    //   Abstract functions
    //
    public abstract void draw(Graphics2D g2d);  // Each Thing based class must be able to be drawn
    public abstract void update();              // Each Thing based class must update (even if nothing updates)

    /////
    //   Getter functions, self-explanatory
    //
    public final long       getID       ()      { return (ID);              }
    public final XYValue    getLocation ()      { return (location);        }
    public final float      getX        ()      { return (location.getX()); }
    public final float      getY        ()      { return (location.getY()); }

    /////
    //   Setter functions, pretty self-explanatory
    //
    public final void setLocation (XYValue location)  { this.location.set(location); }
    public final void setLocation (float x, float y)  { this.location.set(x, y);     }
    public final void setX        (float x)           { this.location.setX(x);       }
    public final void setY        (float y)           { this.location.setY(y);       }

    /////
    //   toString must be overridden to call toString from super and then draw info specific to derived class
    //
    @Override
    public String toString() {
        return ("ID : " + ID + "\nLocation :\n" + location.toString());
    }

}
