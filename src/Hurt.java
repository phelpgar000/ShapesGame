import java.awt.*;

public class Hurt extends Objects{

    private boolean isRemove;

    public Hurt(Color color, int x, int y, int width, int height){
        super(color, x, y, width, height);
        isRemove = false;
    }

    public void move(int boardWidth, int boardHeight) {

        if (x < 0 || x > boardWidth) {
            isRemove = true;
        }
        if (y < 0 || y > boardHeight) {
            isRemove = true;
        }

        y += 10;
    }

    @Override
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public boolean isRemove(){
        return isRemove;
    }
}
