package entities;

import config.Config;
import engine.InputHandler;

import java.awt.*;

public class Ball {

    private Double positionX, positionY;
    private Double angle = calAngle();


    public Ball(Double positionX, Double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void update(int screenWidth, int screenHeight) {
        positionX += Config.getBallSpeed() * Math.cos(angle);
        positionY += Config.getBallSpeed() * Math.sin(angle);;
        clampPosition(screenWidth, screenHeight);
    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(positionX.intValue(), positionY.intValue(), Config.getBallWidth(), Config.getBallHeight());
    }

    private void clampPosition(int screenWidth, int screenHeight){
        positionX = Math.max(0, Math.min(positionX, screenWidth - Config.getBallWidth()));
        positionY = Math.max(0, Math.min(positionY, screenHeight - Config.getBallHeight()));
    }

    private static Double calAngle() {
        double angle = Math.random() * (2 * Math.PI);
        return angle;
    }
}
