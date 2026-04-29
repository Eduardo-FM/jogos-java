package engine;

import builder.FrameBuilder;

import javax.swing.*;
import java.awt.*;

public class Game {

    public final static  void start(){
        JFrame frame = new FrameBuilder("Pong")
                .size(800,600)
                .closeOnExit()
                .center()
                .build();
    }
}
