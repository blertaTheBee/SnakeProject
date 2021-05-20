import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Snake {

    //the way the snake moves
    private int dirX, dirY;


    //the body of the snake
    private ArrayList<BodyPart> snakeBody;

    //Constructor
    public Snake(int startingSize, int startingX, int startingY, int bodyPartSize) {

        snakeBody = new ArrayList<>();

        for (int bodyPartNumber = 0; bodyPartNumber < startingSize; bodyPartNumber++) {

            BodyPart bodyPart = new BodyPart(startingX - bodyPartNumber * bodyPartSize,
                    startingY, bodyPartSize);

            snakeBody.add(bodyPart);
        }


    }

    public void move(boolean ateFood, int width, int height) {
        if (dirX != 0 || dirY != 0) {
            BodyPart head = snakeBody.get(0);
            int previousBodyPartX = head.getPosX();
            int previousBodyPartY = head.getPosY();


            head.setPosX(head.getPosX() + dirX * head.getBodyPartSize());
            head.setPosY(head.getPosY() + dirY * head.getBodyPartSize());

            if (head.getPosX() > width-20) {
                head.setPosX(0);
            }
            if (head.getPosX() < 0) {
                head.setPosX(width - 25);
            }
            if (head.getPosY() > height-20) {
                head.setPosY(0);
            }
            if (head.getPosY() < 0) {
                head.setPosY(height - 25);
            }


            ArrayList<BodyPart> newSnake = new ArrayList<>();
            newSnake.add(head);
            int food = 0;
            if (ateFood) {
                food = 1;
            }
            for (int i = 1; i < snakeBody.size() + food; i++) {
                BodyPart bodyPart = new BodyPart(previousBodyPartX, previousBodyPartY, head.getBodyPartSize());
                newSnake.add(bodyPart);
                if (i < snakeBody.size() + food - 1) {
                    previousBodyPartX = snakeBody.get(i).getPosX();
                    previousBodyPartY = snakeBody.get(i).getPosY();
                }
            }
            snakeBody = newSnake;
        }
    }

    public boolean checkIfDead() {
        BodyPart head = snakeBody.get(0);
        Rectangle2D headRec = new Rectangle2D.Double(head.getPosX(), head.getPosY(), head.getBodyPartSize(), head.getBodyPartSize());

        boolean isDead = false;

        for (BodyPart bodyPart : snakeBody) {
            if (bodyPart != head) {
                Rectangle2D bodyPartRec = new Rectangle2D.Double(bodyPart.getPosX(), bodyPart.getPosY(), bodyPart.getBodyPartSize(), bodyPart.getBodyPartSize());

                isDead = headRec.intersects(bodyPartRec);
                if (isDead == true) {
                    break;
                }
            }
        }
        return isDead;
    }

    public ArrayList<BodyPart> getSnakeBody() {
        return snakeBody;
    }


    public void setSnakeBody(ArrayList<BodyPart> snakeBody) {
        this.snakeBody = snakeBody;
    }

    public int getDirX() {
        return dirX;
    }

    public int getDirY() {
        return dirY;
    }

    public void setDirX(int dirX) {
        this.dirX = dirX;
    }

    public void setDirY(int dirY) {
        this.dirY = dirY;
    }
}
