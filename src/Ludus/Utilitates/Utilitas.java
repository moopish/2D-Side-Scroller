package Ludus.Utilitates;

/**
 * Created by Michael on 07/12/2014.
 *
 */
public final class Utilitas {

    public static boolean inRange   (int x, int low, int high) { return (low <= x && high >= x); }
    public static boolean outOfRange(int x, int low, int high) { return (!inRange(x, low, high)); }

}
