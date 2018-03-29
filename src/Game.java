import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener{

    Board board;
    Stats stats;
    Objects player;

    boolean rightPressed, leftPressed;

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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            Stats.toggleRight();
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            Stats.toggleLeft();
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            board.Shoot();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            Stats.toggleRight();
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            Stats.toggleLeft();
        }
    }
}
