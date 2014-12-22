package Game.Things.MovableThings.RotatableThings;

import Game.Drawers.Drawer;
import Game.Things.MovableThings.MovableThing;
import Game.Utilities.Angle;
import Game.Utilities.XYValue;

/**
 * Created by Michael on 21/12/2014.
 */
public abstract class RotatableThing extends MovableThing {

    private Angle facingAngle;
    private Angle rotation;

    public RotatableThing() {
        super();
        setFacingAngle(0f);
        setRotation(0f);
    }

    public RotatableThing(Drawer drawer, XYValue location, XYValue movement, Angle facingAngle) {
        this(drawer, location, movement, facingAngle, new Angle(0f));
    }

    public RotatableThing(Drawer drawer, XYValue location, XYValue movement, Angle facingAngle, Angle rotation) {
        super(drawer, location, movement);
        setRotation(rotation);
        setFacingAngle(facingAngle);
    }

    public Angle getFacingAngle() { return (facingAngle); }
    public Angle getRotation()    { return (rotation);    }

    public void setFacingAngle(Angle facingAngle) { this.facingAngle = new Angle(facingAngle); }
    public void setFacingAngle(float facingAngle) { setFacingAngle(new Angle(facingAngle));    }
    public void setRotation   (Angle rotation)    { this.rotation = new Angle(rotation);       }
    public void setRotation   (float rotation)    { setRotation(new Angle(rotation));          }
}
