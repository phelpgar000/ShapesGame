import javax.swing.*;
import java.awt.event.KeyAdapter;

public class Game extends JFrame {

    Board board;

    boolean leftPressed, rightPressed;

    public Game(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setTitle("GALAKA");
        board = new Board();
        add(board);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args){
        Game game = new Game();
        game.board.setStage();
    }

    addKeyListener((new KeyAdapter) )

    public boolean isLeftPressed(){
        return leftPressed;
    }
    public boolean isRightPressed(){
        return rightPressed;
    }
}
