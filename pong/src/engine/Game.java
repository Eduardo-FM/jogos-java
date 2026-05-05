package engine;

import builder.FrameBuilder;
import config.Config;
import graphics.GamePanel;

import javax.swing.*;

public class Game {

    public final static  void start(){
        JFrame frame = new FrameBuilder(Config.getGameName())
                .addPanel(new GamePanel())
                .size(Config.getScreenWidth(),Config.getScreenHeight())
                .closeOnExit()
                .center()
                .build();
    }
}
