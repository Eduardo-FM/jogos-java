package engine;

import builder.FrameBuilder;
import config.Config;

import javax.swing.*;

public class Game {

    public final static  void start(){
        JFrame frame = new FrameBuilder(Config.getGameName())
                .size(Config.getScreenWidth(),Config.getScreenHeight())
                .closeOnExit()
                .center()
                .build();
    }
}
