package Ludus.Res;

import Ludus.Utilitates.Situs;

/**
 * Created by Michael on 04/12/2014.
 *
 * Res Class (Thing Class)
 */
public abstract class Res {

    private Situs location;
    private Situs movement;

    protected Res(){

    }

    public void setLocation(Situs location)   { this.location.set(location); }
    public void setLocation(float x, float y) { this.location.set(x, y);     }

    public void setMovement(Situs movement)   { this.movement.set(movement); }
    public void setMovement(float x, float y) { this.movement.set(x, y);     }

}
