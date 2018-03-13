import java.awt.*;

public class Objects implements Move, Paint{

    Color color;
    public int x, y, width, height;

    double dx, dy;

    public Objects(Color color, int x, int y, int width, int height){
        this.color = color;
        this.x = x - width/2;
        this.y = y - height/2;
        this.width = width;
        this.height = height;
    }

    @Override
    public void move() {
        /*if(rightPressed){
            dx = 1;
        }
        if(leftPressed){
            dx = -1;
        }

        x*=dx;
        */
    }

    @Override
    public Rectangle getBounds() {
        return null;
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
