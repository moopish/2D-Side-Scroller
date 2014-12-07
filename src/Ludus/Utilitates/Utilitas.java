package Ludus.Utilitates;

/**
 * Created by Michael on 07/12/2014.
 *
 */
public final class Utilitas {

    public static boolean inRange   (byte x, byte low, byte high)       { return (low <= x && high >= x);  }
    public static boolean inRange   (double x, double low, double high) { return (low <= x && high >= x);  }
    public static boolean inRange   (float x, float low, float high)    { return (low <= x && high >= x);  }
    public static boolean inRange   (int x, int low, int high)          { return (low <= x && high >= x);  }
    public static boolean inRange   (long x, long low, long high)       { return (low <= x && high >= x);  }
    public static boolean inRange   (short x, short low, short high)    { return (low <= x && high >= x);  }

    public static boolean outOfRange(byte x, byte low, byte high)       { return (!inRange(x, low, high)); }
    public static boolean outOfRange(double x, double low, double high) { return (!inRange(x, low, high)); }
    public static boolean outOfRange(float x, float low, float high)    { return (!inRange(x, low, high)); }
    public static boolean outOfRange(int x, int low, int high)          { return (!inRange(x, low, high)); }
    public static boolean outOfRange(long x, long low, long high)       { return (!inRange(x, low, high)); }
    public static boolean outOfRange(short x, short low, short high)    { return (!inRange(x, low, high)); }

}
