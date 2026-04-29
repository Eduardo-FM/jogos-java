package entities;

import config.Config;
import engine.InputHandler;

import java.awt.*;

public class Ball {

    private int positionX, positionY;
    private int ballSpeed = Config.getBallSpeed();

    public Ball(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void update(InputHandler inputHandler) {
        if (inputHandler.up) {
            positionY -= ballSpeed;
        }
        if (inputHandler.down) {
            positionY += ballSpeed;
        }
        if (inputHandler.left) {
            positionX -= ballSpeed;
        }
        if (inputHandler.right) {
            positionX += ballSpeed;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(positionX, positionY, Config.getBallWidth(), Config.getBallHeight());
    }
}
