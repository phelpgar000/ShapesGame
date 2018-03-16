import java.awt.*;

public class Enemies extends Objects{

    public Enemies(Color color, int x, int y, int width, int height, Game game){
        super(color, x, y, width, height, game);
    }

    @Override
    public void paint(Graphics g){

        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

}
