public class BodyPart {
    //Instance varibles
    private int posX, posY;

    //Size of body part
    private int bodyPartSize;

    //Constructor
    public BodyPart(int posX, int posY, int bodyPartSize) {
        this.posX = posX;
        this.posY = posY;
        this.bodyPartSize = bodyPartSize;
    }


    public int getBodyPartSize() {
        return bodyPartSize;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
