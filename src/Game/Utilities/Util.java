package Game.Utilities;

/**
 * /////
 * //   The Util Class
 * //       Author : Michael van Dyk
 * //      Created : 07/12/2014
 * ////////////////////
 *      //
 *      //      This is a class that holds all util functions
 *      //
 *
 */
public final class Util {

    /////
    //   These function check if a value is inside the specified range
    //      inRange         checks if it is inside including the edge values
    //      inRangeExcl     checks if it is inside excluding the edge values
    //      inRangeExclIncl checks if it is inside excluding the lower bound, including the upper
    //      inRangeInclExcl checks if it is inside including the lower bound, excluding the upper
    //
    //   Parameters:
    //      double x    - the value to check if in the range
    //      double low  - the lower bound of the range
    //      double high - the upper bounds on the range
    //
    public static boolean inRange         (double x, double low, double high) { return (low <= x && high >= x);  }
    public static boolean inRangeExcl     (double x, double low, double high) { return (low < x && high > x);    }
    public static boolean inRangeExclIncl (double x, double low, double high) { return (low < x && high >= x);   }
    public static boolean inRangeInclExcl (double x, double low, double high) { return (low <= x && high > x);   }

    /////
    //   Contra functions to the inRange, checks to see if outside the given range
    //      follows that outOfRange(whatever) == !inRange(whatever)
    //
    public static boolean outOfRange         (double x, double low, double high) { return (!inRange(x, low, high));         }
    public static boolean outOfRangeExcl     (double x, double low, double high) { return (!inRangeExcl(x, low, high));     }
    public static boolean outOfRangeExclIncl (double x, double low, double high) { return (!inRangeExclIncl(x, low, high)); }
    public static boolean outOfRangeInclExcl (double x, double low, double high) { return (!inRangeInclExcl(x, low, high)); }

    /////
    //   A function that returns a random boolean value
    //
    public static boolean randBool() { return (1 == (int)(Math.random()*2)); }

    /////
    //   These functions give a random integer from the given range
    //      If values 1 and 5 are given an integer x, such that 1<=x<=5 will be returned
    //
    //   Parameters:
    //      int min - the lower bound on the range
    //      int max - the upper bound on the range
    //      (if only one value is given min is set to 0)
    //
    public static int randIntRange(int max) { return (randIntRange(0, max)); }
    public static int randIntRange(int min, int max) {
        if (min > max) {
            int temp = max;
            max = min;
            min = temp;
        }
        return ((int)(Math.random()*(max-min+1))+min);
    }

}
