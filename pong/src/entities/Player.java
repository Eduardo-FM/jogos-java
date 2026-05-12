package entities;

import config.Config;
import engine.InputHandler;

import java.awt.*;

public class Player {

    private double positionX, positionY;
    private final double speed = Config.getBallSpeed();
    private final int width = Config.getRectangleWidth();
    private final int height = Config.getRectangleHeight();

    public Player(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    private void detectedScreeLimits(int screenHeight) {
        int playerheight =height;

        if (positionY <= 0) {
            positionY = 0.0;
        }

        if (positionY + playerheight >= screenHeight) {
            positionY = (screenHeight - playerheight);
        }
    }

    public void setPosition(double positionY) {
        this.positionY = positionY;
    }

    public void update(int screenHeight, InputHandler input){
        if (input.up) positionY -= speed;
        if (input.down) positionY += speed;

        detectedScreeLimits(screenHeight);
    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect( (int) positionX, (int) positionY,
                width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(
                (int) positionX,
                (int) positionY,
                width,
                height
        );
    }
}
