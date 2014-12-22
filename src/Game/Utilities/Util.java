package Game.Utilities;

/**
 * Created by Michael on 07/12/2014.
 *
 */
public final class Util {

    public static boolean inRange   (double x, double low, double high) { return (low <= x && high >= x);  }

    public static boolean outOfRange(double x, double low, double high) { return (!inRange(x, low, high)); }

    public static boolean randBool() { return (1 == (int)(Math.random()*2)); }

    public static int randIntRange(int max)          { return (randIntRange(0, max)); }

    public static int randIntRange(int min, int max) {
        if (min > max) {
            int temp = max;
            max = min;
            min = temp;
        }
        return ((int)(Math.random()*(max-min+1))+min);
    }

}
