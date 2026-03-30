package engine;

import javax.swing.*;
import java.awt.*;

public class Game {

    public final static  void start(){
        JFrame frame = new JFrame("Pong");

        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
