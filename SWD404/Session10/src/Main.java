import com.golden.gamedev.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        GameLoader gameLoader = new GameLoader();
        MyGame g = new MyGame();
        gameLoader.setup(g, new Dimension(640, 480), false);
        gameLoader.start();

    }


}
