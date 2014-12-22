package Game.Utilities;

/**
 * Created by Michael on 05/12/2014.
 *
 *  Angulus class (angle class)
 */
public class Angle {

    // TODO MASSIVE TESTING

    private static final AngulusType DEFAULT_TYPE = AngulusType.RADIANS;

    private float           angle;
    private AngulusType     angleType;

    public enum AngulusType {
        DEGREES  (1f, 10f/9f, (float)(Math.PI/180f), 360f, "DEGREES"),
        GRADIANS (0.9f, 1f, (float)(Math.PI/200f), 400f, "GRADIANS"),
        RADIANS  ((float)(180f/Math.PI), (float)(200f/Math.PI), 1f, (float)Math.PI*2, "RADIANS");

        private float  toDegrees;
        private float  toGradians;
        private float  toRadians;
        private float  absoluteMax;
        private String typeName;

        AngulusType(float toDegrees, float toGradians, float toRadians, float absoluteMax, String typeName) {
            this.toDegrees = toDegrees;
            this.toGradians = toGradians;
            this.toRadians = toRadians;
            this.absoluteMax = absoluteMax;
            this.typeName = typeName;
        }

        public float convert(float angle, AngulusType to) {
            switch (to) {
                case DEGREES:
                    angle = toDegrees(angle);
                    break;
                case GRADIANS:
                    angle = toGradians(angle);
                    break;
                case RADIANS:
                    angle = toRadians(angle);
                    break;
            }

            return (angle);
        }

        public float reduce(float angle) {
            if (angle >= absoluteMax)
                angle -= absoluteMax;
            else if (angle <= -absoluteMax)
                angle += absoluteMax;

            return (angle);
        }

        public float toDegrees  (float value)  { return (value * toDegrees);  }
        public float toGradians (float value)  { return (value * toGradians); }
        public float toRadians  (float value)  { return (value * toRadians);  }

        public String getTypeName() { return (typeName); }
    }

    public Angle(float angle) { this(angle, DEFAULT_TYPE); }

    public Angle(float angle, AngulusType angleType) {
        this.angleType = angleType;
        this.angle = angleType.reduce(angle);
    }

    public Angle(Angle angle) { this(angle, angle.angleType); }

    public Angle(Angle angle, AngulusType to) {
        this.angleType = to;
        this.angle = reduce(convert(angle.angle, to), to);
    }

    public void add(Angle amount) { add(convert(amount.angle, amount.angleType, this.angleType)); }

    public void add(float amount) {
        this.angle += amount;
        reduce();
    }

    public float convert(AngulusType to) {
        this.angle = convert(this.angle, this.angleType, to);
        this.angleType = to;
        return (this.angle);
    }

    public static float convert(float angle, AngulusType to)                   { return (convert(angle, DEFAULT_TYPE, to)); }
    public static float convert(float angle, AngulusType from, AngulusType to) { return (from.convert(angle, to));          }

    public float convertToDegrees() {
        this.angle = convertToDegrees(this.angle, this.angleType);
        this.angleType = AngulusType.DEGREES;
        return (this.angle);
    }

    public static float convertToDegrees  (float angle)                   { return (convertToDegrees(angle, DEFAULT_TYPE)); }
    public static float convertToDegrees  (float angle, AngulusType from) { return (from.toDegrees(angle));                 }

    public float convertToGradians() {
        this.angle = convertToGradians(this.angle, this.angleType);
        this.angleType = AngulusType.GRADIANS;
        return (this.angle);
    }

    public static float convertToGradians (float angle)                   { return (convertToGradians(angle, DEFAULT_TYPE)); }
    public static float convertToGradians (float angle, AngulusType from) { return (from.toGradians(angle));                 }

    public float convertToRadians() {
        this.angle = convertToRadians(this.angle, this.angleType);
        this.angleType = AngulusType.RADIANS;
        return (this.angle);
    }

    public static float convertToRadians  (float angle)                   { return (convertToRadians(angle, DEFAULT_TYPE)); }
    public static float convertToRadians  (float angle, AngulusType from) { return (from.toRadians(angle));                 }

    public float        cos()                              { return (cos(angle, angleType)); }
    public static float cos(float angle)                   { return (cos(angle, DEFAULT_TYPE)); }
    public static float cos(float angle, AngulusType from) { return ((float)Math.cos(convert(angle, from, AngulusType.RADIANS))); }

    public static float   findAngle(XYValue a, XYValue b)   { return ((float)Math.asin((b.getY() - a.getX())/a.distance(b))); }
    public static Angle findAngulus(XYValue a, XYValue b) { return (new Angle(findAngle(a, b))); }

    public float reduce() {
        this.angle = reduce(this.angle, this.angleType);
        return (this.angle);
    }

    public static float reduce(float angle)                   { return (reduce(angle, DEFAULT_TYPE)); }
    public static float reduce(float angle, AngulusType type) { return (type.reduce(angle));          }

    public void set(Angle angle) { set(angle, angle.angleType); }

    public void set(Angle angle, AngulusType to) {
        this.angleType = to;
        this.angle = reduce(convert(angle.angle, angle.angleType, to), to);
    }

    public void setAngle(float angle)                                   { setAngle(angle, DEFAULT_TYPE);                     }
    public void setAngle(float angle, AngulusType to)                   { setAngle(angle, DEFAULT_TYPE, to);                 }
    public void setAngle(float angle, AngulusType from, AngulusType to) { this.angle = reduce(convert(angle, from, to), to); }

    public void setAngleType(AngulusType to) { convert(to); }

    public float        sin()                              { return (sin(angle, angleType)); }
    public static float sin(float angle)                   { return (sin(angle, DEFAULT_TYPE)); }
    public static float sin(float angle, AngulusType from) { return ((float)Math.sin(convert(angle, from, AngulusType.RADIANS))); }

    public float        tan()                              { return (tan(angle, angleType)); }
    public static float tan(float angle)                   { return (tan(angle, DEFAULT_TYPE)); }
    public static float tan(float angle, AngulusType from) { return ((float)Math.tan(convert(angle, from, AngulusType.RADIANS))); }

    @Override
    public String toString() {
        return ("Angle Value : " + angle + "\nAngle Type : " + angleType.getTypeName() + "\n");
    }
}
