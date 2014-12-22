package Game.Things.AreaThings.CollectiveThings;

import Game.Things.AreaThings.AreaThing;
import Game.Things.Thing;
import Game.Utilities.XYValue;

import java.awt.*;


/**
 * Created by Michael on 21/12/2014.
 */
public abstract class StaticCollectiveThing<E extends Thing> extends AreaThing {

    private E[] contents;
    private int count;

    @SuppressWarnings("unchecked")
    public StaticCollectiveThing(XYValue location, XYValue dimensions, int count) {
        super(location, dimensions);
        this.count = count;
        contents = (E[]) (new Thing[this.count]);
    }

    @Override
    public void draw(Graphics2D g2d) {
        for (E e : contents)
            e.draw(g2d);
    }

    public E get(int index) { return contents[index]; }
    public void set(E value, int index) { contents[index] = value; }

    public int getCount() { return (count); }

    @Override
    public void update() {
        for (E e : contents)
            e.update();
    }

}
