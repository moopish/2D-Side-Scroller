package Game;

import Game.Things.Stars.Star;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.image.BufferedImage;

/**
 * Created by Michael on 04/12/2014.
 *
 */
public final class Game extends JFrame implements ChangeListener{

    int x = 0;

    public static void main(String[] args) {
        Game game = new Game();
        BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);

        Star star = new Star(0,0,0,0);
        star.draw(bufferedImage);

        game.setIconImage(bufferedImage);
        game.setVisible(true);

        System.exit(0);
    }

    public Game() {
        super();
        setSize(600,600);
    }

    public void stateChanged(ChangeEvent e){
        System.out.println(x++);
    }
}
