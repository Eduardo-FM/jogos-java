package entities;

import engine.InputHandler;

import java.awt.*;

public class Player {

    private int positionX, positionY;
    private int playerSpeed = 5;

    public Player(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void update(InputHandler inputHandler){
        if (inputHandler.up){
            positionY -= playerSpeed;
        }
        if (inputHandler.down){
            positionY += playerSpeed;
        }
        if (inputHandler.left){
            positionX -= playerSpeed;
        }
        if (inputHandler.right){
            positionX += playerSpeed;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(positionX, positionY, 50,50);
    }
}
