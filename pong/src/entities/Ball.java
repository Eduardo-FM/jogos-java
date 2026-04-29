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

    public void update(InputHandler inputHandler, int screenWidth, int screenHeight) {
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

        clampPosition(screenWidth, screenHeight);
    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(positionX, positionY, Config.getBallWidth(), Config.getBallHeight());
    }

    private void clampPosition(int screenWidth, int screenHeight){
        positionX = Math.max(0, Math.min(positionX, screenWidth - Config.getBallWidth()));
        positionY = Math.max(0, Math.min(positionY, screenHeight - Config.getBallHeight()));
    }
}
