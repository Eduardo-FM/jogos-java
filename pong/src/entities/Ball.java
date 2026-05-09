package entities;

import config.Config;
import java.awt.*;

public class Ball {

    private double positionX, positionY;
    private double angle;


    public Ball() {
        this.angle = calAngle();
    }

    public void setPosition(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void update(int screenWidth, int screenHeight) {
        positionX += Config.getBallSpeed() * Math.cos(angle);
        positionY += Config.getBallSpeed() * Math.sin(angle);
        ballReflection(screenWidth, screenHeight);
    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect( (int) positionX, (int) positionY,
                Config.getBallWidth(), Config.getBallHeight());
    }

    private void ballReflection(int screenWidth, int screenHeight){
        int ballWidth = Config.getBallWidth();
        int ballHeight = Config.getBallHeight();

        if (positionX <= 0) {
            positionX = 0.0;
            angle = Math.PI - angle;
        }

        if (positionX + ballWidth >= screenWidth) {
            positionX = (screenWidth - ballWidth);
            angle = Math.PI - angle;
        }

        if (positionY <= 0) {
            positionY = 0;
            angle = -angle;
        }

        if (positionY + ballHeight >= screenHeight) {
            positionY = (screenHeight - ballHeight);
            angle = -angle;
        }
    }

    private static Double calAngle() {
        double angle = Math.random() * (2 * Math.PI);

        double minAngle = Math.toRadians(20);

        if (Math.abs(Math.cos(angle)) < Math.cos(Math.PI / 2 - minAngle)) {
            angle += minAngle;
        }

        return angle;
    }
}
