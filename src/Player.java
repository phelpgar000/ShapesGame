import java.awt.*;

public class Player extends Objects{

    private final int SPED = 5;

    Game game;
    Board board;

    public Player(Color color, int x, int y, int width, int height){
        super(color, x, y, width, height);
    }

    @Override
    public void paint(Graphics g){

        g.setColor(color);
        g.fillOval(x, y, width, height);
    }

    @Override
    public void move(int boardWidth){
        if(game.isLeftPressed()){
            if(x > 0){
                x -= SPED;
            }
        }
        if(game.isRightPressed()){
            if(x < boardWidth - width){
                x += SPED;
            }
        }
    }
}
