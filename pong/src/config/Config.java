package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static Properties properties = new Properties();

    static {
        try {
            InputStream input = Config.class
                    .getClassLoader()
                    .getResourceAsStream("game.properties");

            if (input == null){
                throw new NullPointerException("Arquivo game.properties nao encontrado");
            }

            properties.load(input);
        } catch (NullPointerException | IOException exception) {
            exception.printStackTrace();
        }
    }

    public static int getScreenWidth() {
        return Integer.parseInt(properties.getProperty("screen.width"));
    }

    public static int getScreenHeight() {
        return Integer.parseInt(properties.getProperty("screen.height"));
    }

    public static String getGameName(){
        return String.valueOf(properties.getProperty("game.name"));
    }

    public static int getBallSpeed(){
        return Integer.parseInt(properties.getProperty("ball.speed"));
    }

    public static int getBallWidth(){
        return Integer.parseInt(properties.getProperty("ball.width"));
    }

    public static int getBallHeight(){
        return Integer.parseInt(properties.getProperty("ball.height"));
    }

    public static int getRectangleSpeed(){
        return Integer.parseInt(properties.getProperty("player.speed"));
    }

    public static int getPlayerHeight(){
        return Integer.parseInt(properties.getProperty("player.height"));
    }

    public static int getPlayerWidth(){
        return Integer.parseInt(properties.getProperty("player.width"));
    }

    public static int getPlayerMargin(){
        return Integer.parseInt(properties.getProperty("player.margin"));
    }
}
