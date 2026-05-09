package graphics;

import engine.InputHandler;
import entities.Ball;
import entities.Rectangle;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    private Thread thread;
    private Boolean running;
    private Ball ball;
    private Rectangle player;
    private InputHandler input;

    public GamePanel() {
        setFocusable(true);

        input = new InputHandler();
        addKeyListener(input);
        Double ballPositionX = 100.0;
        Double ballPositionY = 100.0;
        Double playerPositionX = 70.0;
        Double playerPositionY = 100.0;

        ball = new Ball(ballPositionX, ballPositionY);
        player = new Rectangle(playerPositionX, playerPositionY);
        start();
    }

    public void start(){
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void update(){
        ball.update(getWidth(), getHeight());
        player.update(input);
    }

    @Override
    public void run() {
        while (running) {
            update();
            repaint();

            try {
                Thread.sleep(16);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0,0, getWidth(), getHeight());

        ball.render(g);
        player.render(g);
        Toolkit.getDefaultToolkit().sync();
    }
}
