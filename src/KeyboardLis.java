import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardLis implements KeyListener {

    private Snake snake;

    //Constructor
    public KeyboardLis(Snake snake) {
        this.snake = snake;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //up -> case VK_KP_IP
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                if (snake.getDirY() != 1) {
                    snake.setDirX(0);
                    snake.setDirY(-1);
                }
                break;
            case KeyEvent.VK_S:
                if (snake.getDirY() != -1)
                    snake.setDirX(0);
                snake.setDirY(1);
                break;
            case KeyEvent.VK_A:
                if (snake.getDirX() != 1) {
                    snake.setDirX(-1);
                    snake.setDirY(0);
                }
                break;
            case KeyEvent.VK_D:
                if (snake.getDirX() != -1) {
                    snake.setDirX(1);
                    snake.setDirY(0);
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
