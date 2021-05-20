import javax.swing.*;
import java.awt.*;

public class Drawer extends JFrame {


    public Drawer(int width, int height, Snake snake) {

        setSize(width, height);
        addKeyListener(new KeyboardLis(snake));

        Food food = new Food(20, 20, 15, Color.pink);

        GamePanel panel = new GamePanel(snake, food, width, height);

        getContentPane().add(panel);

        setVisible(true);

    }

    public static void main(String[] args) {
        Snake snake = new Snake(3, 30, 10, 15);
        new Drawer(500, 500, snake);
    }


}
