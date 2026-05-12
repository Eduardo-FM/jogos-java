package entities;

import config.Config;
import java.awt.*;

public class Ball {

    private double positionX, positionY;
    private double angle;
    private final double speed = Config.getBallSpeed();
    private final int width = Config.getBallWidth();
    private final int height = Config.getBallHeight();

    public Ball() {
        this.angle = calAngle();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void move() {
        positionX += Math.cos(angle) * speed;
        positionY += Math.sin(angle) * speed;
    }

    private void handlePlayerCollision(Player player) {
        Rectangle ball = getBounds();
        Rectangle p = player.getBounds();

        if (!ball.intersects(p)) return;

        double ballCenterX = positionX + width / 2.0;
        double ballCenterY = positionY + height / 2.0;

        double playerCenterX = p.x + p.width / 2.0;
        double playerCenterY = p.y + p.height / 2.0;

        double dx = ballCenterX - playerCenterX;
        double dy = ballCenterY - playerCenterY;

        double overlapX = (width / 2.0 + p.width / 2.0) - Math.abs(dx);
        double overlapY = (height / 2.0 + p.height / 2.0) - Math.abs(dy);

        if (overlapX < overlapY) {
            reflectHorizontal(dx, overlapX);
        } else {
            reflectVertical(dy, overlapY);
        }
    }

    private void reflectHorizontal(double dx, double overlapX) {
        angle = Math.PI - angle;
        positionX += (dx > 0) ? overlapX : -overlapX;
    }

    private void reflectVertical(double dy, double overlapY) {
        angle = -angle;
        positionY += (dy > 0) ? overlapY : -overlapY;
    }

    private void handleWallCollision(int screenWidth, int screenHeight){

        if (positionX <= 0) {
            positionX = 0.0;
            angle = Math.PI - angle;
        }

        if (positionX + getWidth() >= screenWidth) {
            positionX = (screenWidth - getWidth());
            angle = Math.PI - angle;
        }

        if (positionY <= 0) {
            positionY = 0;
            angle = -angle;
        }

        if (positionY + getHeight() >= screenHeight) {
            positionY = (screenHeight - getHeight());
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

    public void setPosition(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void update(int screenWidth, int screenHeight, Player player) {
        move();
        handlePlayerCollision(player);
        handleWallCollision(screenWidth, screenHeight);
    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect( (int) positionX, (int) positionY,
                width, height);
    }

    public java.awt.Rectangle getBounds() {
        return new java.awt.Rectangle(
                (int) positionX,
                (int) positionY,
                width,
                height
        );
    }

}
