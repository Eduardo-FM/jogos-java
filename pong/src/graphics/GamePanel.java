package graphics;

import config.Config;
import engine.InputHandler;
import entities.Ball;
import entities.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    private Thread thread;
    private Boolean running;
    private Ball ball;
    private Player player;
    private InputHandler input;

    private boolean initialized = false;

    public GamePanel() {
        setFocusable(true);

        input = new InputHandler();
        addKeyListener(input);
        Double playerPositionX = 70.0;
        Double playerPositionY = 100.0;

        ball = new Ball();
        player = new Player(playerPositionX, playerPositionY);
        start();
    }

    public void start(){
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void update(){
        if (!initialized && getWidth() > 0 && getHeight() > 0){
            double positionX = (getWidth() - Config.getBallWidth( )) / 2.0;
            double positionY = (getHeight() - Config.getBallHeight()) / 2.0;
            double playerPositionY = (getHeight() - Config.getRectangleHeight()) / 2.0;

            ball.setPosition(positionX, positionY);
            player.setPosition(playerPositionY);
            initialized = true;
        }

        ball.update(getWidth(), getHeight(), player);
        player.update(getHeight(), input);
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
