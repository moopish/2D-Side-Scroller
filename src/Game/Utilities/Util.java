package Game.Utilities;

/**
 * Created by Michael on 07/12/2014.
 *
 */
public final class Util {

    public static boolean inRange   (double x, double low, double high) { return (low <= x && high >= x);  }

    public static boolean outOfRange(double x, double low, double high) { return (!inRange(x, low, high)); }

}
