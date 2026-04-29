package builder;

import graphics.GamePanel;

import javax.swing.*;
import java.awt.*;

public class FrameBuilder {

    private JFrame frame;
    private static final GamePanel panel = new GamePanel();

    public FrameBuilder(String title) {
        this.frame = new JFrame(title);
        frame.add(panel);
    }

    public FrameBuilder size(int width, int height) {
        frame.setSize(width, height);
        return this;
    }

    public FrameBuilder closeOnExit() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return this;
    }

    public FrameBuilder center() {
        frame.setLocationRelativeTo(null);
        return this;
    }

    public JFrame build() {
        frame.setVisible(true);
        return frame;
    }

}
