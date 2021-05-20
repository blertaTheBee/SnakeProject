import java.awt.*;

public class Food {

    private int posX, posY;
    private int foodSize;
    private Color foodColor;

    //Constructor
    public Food(int posX, int posY, int foodSize, Color foodColor) {
        this.posX = posX;
        this.posY = posY;
        this.foodSize = foodSize;
        this.foodColor = foodColor;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getFoodSize() {
        return foodSize;
    }

    public void setFoodSize(int foodSize) {
        this.foodSize = foodSize;
    }

    public Color getFoodColor() {
        return foodColor;
    }

    public void setFoodColor(Color foodColor) {
        this.foodColor = foodColor;
    }
}

