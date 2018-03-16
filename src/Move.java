import java.awt.*;

public interface Move {

    public void move(int boardWidth);

    public void moveRight();

    public void moveLeft(int boardWidth);

    public Rectangle getBounds();

}
