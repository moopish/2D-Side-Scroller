package Ludus.Utilitates;

/**
 * Created by Michael on 05/12/2014.
 *
 *  Angulus class (angle class)
 */
public class Angulus {

    private static final AngulusType DEFAULT_TYPE = AngulusType.RADIANS;

    private float           angle;
    private AngulusType     angleType;

    public enum AngulusType {
        DEGREES  (1f, 10f/9f, (float)(Math.PI/180f), 360f),
        GRADIANS (0.9f, 1f, (float)(Math.PI/200f), 400f),
        RADIANS  ((float)(180f/Math.PI), (float)(200f/Math.PI), 1f, (float)Math.PI*2);

        private float toDegrees;
        private float toGradians;
        private float toRadians;
        private float absoluteMax;

        AngulusType(float toDegrees, float toGradians, float toRadians, float absoluteMax) {
            this.toDegrees = toDegrees;
            this.toGradians = toGradians;
            this.toRadians = toRadians;
            this.absoluteMax = absoluteMax;
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
            else if (angle < 0f)
                angle += absoluteMax;

            return (angle);
        }

        public float toDegrees  (float value)  { return (value * toDegrees);  }
        public float toGradians (float value)  { return (value * toGradians); }
        public float toRadians  (float value)  { return (value * toRadians);  }
    }

    public Angulus(float angle) { this(angle, DEFAULT_TYPE); }

    public Angulus(float angle, AngulusType angleType) {
        this.angleType = angleType;
        this.angle = angleType.reduce(angle);
    }

    public Angulus(Angulus angulus) { this(angulus, angulus.angleType); }

    public Angulus(Angulus angulus, AngulusType to) {
        this.angleType = to;
        this.angle = reduce(convert(angulus.angle, to), to);
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

    public static float convertToDegrees  (float angle)                   { return (convertToDegrees(angle, DEFAULT_TYPE));  }
    public static float convertToDegrees  (float angle, AngulusType from) { return (from.toDegrees(angle));                  }

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

    public static float convertToRadians  (float angle)                   { return (convertToRadians(angle, DEFAULT_TYPE));  }
    public static float convertToRadians  (float angle, AngulusType from) { return (from.toRadians(angle));                  }

    public float reduce() {
        this.angle = reduce(this.angle, this.angleType);
        return (this.angle);
    }

    public static float reduce(float angle)                   { return (reduce(angle, DEFAULT_TYPE)); }
    public static float reduce(float angle, AngulusType type) { return (type.reduce(angle));          }


    public void set(Angulus angulus) { set(angulus, angulus.angleType); }

    public void set(Angulus angulus, AngulusType to) {
        this.angleType = to;
        this.angle = reduce(convert(angulus.angle, angulus.angleType, to), to);
    }

    public void setAngle(float angle)                                   { setAngle(angle, DEFAULT_TYPE); }
    public void setAngle(float angle, AngulusType to)                   { setAngle(angle, DEFAULT_TYPE, to); }
    public void setAngle(float angle, AngulusType from, AngulusType to) { this.angle = reduce(convert(angle, from, to), to); }

    public static void main(String[] args) {

    }

}
