package entities;

import config.Config;
import engine.InputHandler;

import java.awt.*;

public class Rectangle {

    private double positionX, positionY;
    private int speed = Config.getRectangleSpeed();

    public Rectangle(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void update(InputHandler input){
        if (input.up) positionY -= speed;
        if (input.down) positionY += speed;
    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect( (int) positionX, (int) positionY,
                Config.getRectangleWidth(), Config.getRectangleHeight());
    }
}
