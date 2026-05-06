package engine;

import builder.FrameBuilder;
import config.Config;
import graphics.GamePanel;


public class Game {

    public final static  void start(){
        createGameFrame();
    }

    private static void createGameFrame() {
        new FrameBuilder(Config.getGameName())
                .addPanel(new GamePanel())
                .size(Config.getScreenWidth(),Config.getScreenHeight())
                .closeOnExit()
                .center()
                .build();
    }
}
