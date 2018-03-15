import java.awt.*;

public class Objects implements Move, Paint{

    Color color;
    public int x, y, width, height;

    public int SPED = 5;
    boolean leftPressed, rightPressed;

    Game game;
    Board board;

    double dx, dy;

    public Objects(Color color, int x, int y, int width, int height){
        this.color = color;
        this.x = x - width/2;
        this.y = y - height/2;
        this.width = width;
        this.height = height;
    }

    @Override
    public void move(int boardWidth) {

    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)(x + dx), (int)(y + dy), width, height);
    }

    @Override
    public void paint(Graphics g) {

    }

    @Override
    public void setPosition(int x, int y) {

        this.x = x;
        this.y = y;

    }
}
