package Ludus.Res.Stellae;

import Ludus.Res.Res;
import Ludus.Simulacra.Simulacrum;
import Ludus.Simulacra.Stellae.SimulacrumStellae;
import Ludus.Utilitates.Situs;

/**
 * Created by Michael on 04/12/2014.
 *
 */
public final class Stella extends Res{

    private int size;
    // TODO add colour

    public Stella() {
        super();
        setDrawer(new SimulacrumStellae());
    }

    public Stella(float xPosition, float yPosition, float xVelocity, float yVelocity, Simulacrum drawer){
        super(new Situs(xPosition, yPosition), new Situs(xVelocity, yVelocity), drawer);
        setDrawer(new SimulacrumStellae());
    }

    public Stella(Situs location, float xVelocity, float yVelocity, Simulacrum drawer) {
        super(location, new Situs(xVelocity, yVelocity), drawer);
        setDrawer(new SimulacrumStellae());
    }

    public Stella(float xPosition, float yPosition, Situs movement, Simulacrum drawer){
        super(new Situs(xPosition, yPosition), movement, drawer);
    }

    public Stella(Situs location, Situs movement, Simulacrum drawer) {
        super(location, movement, drawer);
        setDrawer(new SimulacrumStellae());
    }

    public Stella(Stella copy) {
        this();
        set(copy);
    }

    public void set(Stella copy) {

    }
}
