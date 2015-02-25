package Game;

import Game.Things.AreaThings.CollectiveThings.LayeredStarField;
import Game.Utilities.Angle;
import Game.Utilities.XYValue;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Michael on 04/12/2014.
 *
 */
public final class Game extends JFrame{

    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;

    private JLabel screen;

    public static void main(String[] args) {
        Game game = new Game();
        BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = bufferedImage.createGraphics();

        LayeredStarField test = new LayeredStarField(new XYValue(WIDTH, HEIGHT), 250, 5, new Angle((float)(Math.PI/2)), true);
        game.setVisible(true);

        System.out.println(test.toString());

        while (true) {
            g2d.setPaint(Color.black);
            g2d.fillRect(0, 0, WIDTH, HEIGHT);
            test.draw(g2d);

            //game.setIconImage(bufferedImage);
            game.screen.setIcon(new ImageIcon(bufferedImage));
            test.update();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.exit(-1);
            }
        }


        //System.exit(0);
    }

    public Game() {
        super();
        setSize(WIDTH,HEIGHT);

        screen = new JLabel();
        screen.setLocation(0,0);
        screen.setSize(1000, 400);
        screen.setBackground(Color.black);
        add(screen);
    }

}
