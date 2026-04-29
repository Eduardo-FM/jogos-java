package engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

    public boolean up,down, left, right;

    private void setKeyState(Integer keyCode, Boolean keyState){
        switch (keyCode) {
            case KeyEvent.VK_W:
                up = keyState;
                break;
            case KeyEvent.VK_S:
                down = keyState;
                break;
            case KeyEvent.VK_A:
                left = keyState;
                break;
            case KeyEvent.VK_D:
                right = keyState;
                break;
        }
    }
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        setKeyState(keyEvent.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        setKeyState(keyEvent.getKeyCode(), false);
    }
}
