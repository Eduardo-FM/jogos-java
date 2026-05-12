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

    private static double calcPosition(int basePosition, int objectPosition){
        return (basePosition - objectPosition) / 2.00;
    }

    public GamePanel() {
        setFocusable(true);

        input = new InputHandler();
        addKeyListener(input);

        ball = new Ball();
        player = new Player();
        start();
    }

    public void start(){
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void update(){
        if (!initialized && getWidth() > 0 && getHeight() > 0){
            double positionX = calcPosition(getWidth(), Config.getBallWidth());
            double positionY = calcPosition(getHeight(), Config.getBallHeight());
            double playerPositionY = calcPosition(getHeight(), Config.getPlayerHeight());
            double playerPositionX = Config.getPlayerMargin();

            ball.setPosition(positionX, positionY);
            player.setPosition(playerPositionX, playerPositionY);
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
