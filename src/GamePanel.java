import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class GamePanel extends JPanel {

    private Snake snake;
    private Food food;
    private int width, height;

    //Constructor
    public GamePanel(Snake snake, Food food, int width, int height) {
        this.snake = snake;
        this.food = food;
        this.width = width;
        this.height = height;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        Graphics2D graphics2D = (Graphics2D) g;

        if (snake.checkIfDead() == false) {
            Rectangle2D foodRec = new Rectangle2D.Double(food.getPosX(), food.getPosY(), food.getFoodSize(), food.getFoodSize());
            BodyPart head = snake.getSnakeBody().get(0);
            Rectangle2D headRec = new Rectangle2D.Double(head.getPosX(), head.getPosY(), head.getBodyPartSize(), head.getBodyPartSize());

            boolean ate = headRec.intersects(foodRec);
            snake.move(ate,width,height);

            if (ate) {
                food.setPosX((int) (Math.random() * (width - 50)));
                food.setPosY((int) (Math.random() * (height - 50)));
            }


            //Casting the graphics object to a Graphics2d object

            g.setColor(Color.BLACK);
            graphics2D.draw(foodRec);
            graphics2D.setColor(food.getFoodColor());
            graphics2D.fill(foodRec);


            for (BodyPart bodyPart : snake.getSnakeBody()) {
                Rectangle2D snakeBodyPartRect = new Rectangle2D.Double(bodyPart.getPosX(), bodyPart.getPosY(), bodyPart.getBodyPartSize(), bodyPart.getBodyPartSize());
                g.setColor(Color.BLACK);
                graphics2D.draw(snakeBodyPartRect);
                graphics2D.setColor(Color.GREEN);
                graphics2D.fill(snakeBodyPartRect);
            }

            try {
                Thread.sleep(100);
            } catch (Exception e) {

            }
            repaint();

        } else {
            //display gameover todo
            graphics2D.setColor(Color.GREEN);
            Font font = new Font(Font.SANS_SERIF, Font.BOLD, 30);
            graphics2D.setFont(font);
            graphics2D.drawString("Game Over", width / 3, height / 3);
        }
    }
}
