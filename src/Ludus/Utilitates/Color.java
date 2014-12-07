package Ludus.Utilitates;

/**
 * Created by Michael on 07/12/2014.
 *
 *
 */
public final class Color {

    private int r;
    private int g;
    private int b;

    public Color() { this(0, 0, 0); }

    public Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color(Color c) { set(c); }

    public Color(String str) {
        this();
        set(str);
    }

    public int getR() { return (r); }
    public int getG() { return (g); }
    public int getB() { return (b); }

    public void set(Color c) {
        this.r = c.getR();
        this.g = c.getG();
        this.b = c.getB();
    }

    public void set(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                String[] strSplit = str.split(",");
                int[] intSplit = new int[3];

                if (strSplit.length == intSplit.length) {

                    for (int i = 0; i < intSplit.length; i++) {
                        intSplit[i] = Integer.valueOf(strSplit[i]);
                        if (Utilitas.outOfRange(intSplit[i], 0, 255))
                            intSplit[i] = 0;
                    }

                    r = Integer.valueOf(strSplit[0]);
                    g = Integer.valueOf(strSplit[1]);
                    b = Integer.valueOf(strSplit[2]);
                }
            }
        }
        r = 0;
        g = 0;
        b = 0;
    }

    public void setR(int r) { this.r = r; }
    public void setG(int g) { this.g = g; }
    public void setB(int b) { this.b = b; }

    public String toString() { return (r + "," + g + "," + b); }
}
