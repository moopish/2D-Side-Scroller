package Game.Utilities;

/**
 * Created by Michael on 23/12/2014.
 */
public abstract class Shape {

    private final XYValue[] points;

    private final int pointCount;

    public Shape(int pointCount) {
        this.pointCount = pointCount;
        this.points = new XYValue[pointCount];
    }

    public Shape(XYValue[] points) {
        this.pointCount = points.length;
        this.points = new XYValue[pointCount];

        for (int i=0; i<pointCount; ++i)
            this.points[i] = new XYValue(points[i]);
    }

    public XYValue get(int index) {
        try {
            if (Util.outOfRangeInclExcl(index, 0, pointCount))
                throw new IndexOutOfBoundsException();

            return (points[index]);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            return (null);
        }
    }

    public int getPointCount() { return (pointCount); }

    public void rotate(Angle rotation, XYValue point) {

    }

    public boolean set(int index, XYValue point) {
        try {
            if (Util.outOfRangeInclExcl(index, 0, pointCount))
                throw new IndexOutOfBoundsException();

            points[index] = new XYValue(point);
            return (true);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public boolean set(int index, float x, float y) { return (set(index, new XYValue(x, y))); }

    @Override
    public String toString() {
        String str = "";

        for (int i=0; i<pointCount; ++i) {
            str += "Point " + i + " :\n" + points[i].toString();
        }

        return (str);
    }

    public class InvalidArrayLengthException extends Exception {
        public InvalidArrayLengthException() { super(); }
        public InvalidArrayLengthException(int actual, int required) { this("Shape", actual, required); }
        public InvalidArrayLengthException(String name, int actual, int required) {
            super("Invalid " + name + " length of " + actual + " - needs to be of length " + required);
        }
    }
}
