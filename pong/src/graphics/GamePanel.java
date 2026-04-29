package graphics;

import engine.InputHandler;
import entities.Ball;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    private Thread thread;
    private Boolean running;
    private Ball ball;
    private InputHandler input;

    public GamePanel() {
        setFocusable(true);
        input = new InputHandler();
        addKeyListener(input);
        Integer ballPositionX = 100;
        Integer ballPositionY = 100;

        ball = new Ball(ballPositionX, ballPositionY);
        start();
    }

    public void start(){
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void update(){
        ball.update(input, getWidth(), getHeight());
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
    }
}
