import java.awt.*;

public class Player extends Objects{

    private final int SPED = 5;

    Game game;
    Board board;

    public Player(Color color, int x, int y, int width, int height, Game game){
        super(color, x, y, width, height, game);
    }

    @Override
    public void paint(Graphics g){

        g.setColor(color);
        g.fillOval(x, y, width, height);
    }

    @Override
    public void moveRight(){
        if(x > 0){
            x -= SPED;
        }
    }

    @Override
    public void moveLeft(int boardWidth){
        if(x < boardWidth - width){
            x += SPED;
        }
    }

}
