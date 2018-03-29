import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel implements ActionListener{

    Timer timer;
    List<Objects> visuals = new ArrayList<Objects>();
    Game other;

    int lX, lY, x, y, SCOL = 15, NCOL = 8;
    final int BCOL = 5, BROW = 1, NROW = 7, SROW = 5;
    int army = SCOL*NCOL*SROW*NROW*BCOL*BROW;

    public Board(){
        setPreferredSize(new Dimension(900, 800));
        setBackground(Color.BLACK);

        timer = new Timer(1000/60, this);
        timer.start();
    }

    public void setStage(){

        x = getWidth()/2;
        y = getHeight()/10*9;
        visuals.add( 0, new Player(Color.CYAN, x, y, 35, 25));
        visuals.add(new Attack(Color.green, visuals.get(0).x, visuals.get(0).y, 5, 5));

        for(int i = 0; i < BROW; i++) {
            lY = lY + 75;
            for(int k = 0; k < BCOL; k++) {
                lX = (lX + getWidth()/6);
                visuals.add( new Enemies(Color.BLUE, lX, lY, 75, 25));
            }
            lX = 0;
        }
        lY = 75;
        for(int i = 0; i < NROW; i++){
            lY = lY + 50;
            for(int k = 0; k < NCOL; k++){
                if(i%2 == 0){
                    NCOL = 6;
                    lX = lX + getWidth()/7;
                }
                else{
                    NCOL = 8;
                    lX = lX + getWidth()/9;
                }
                visuals.add(new Enemies(Color.RED, lX, lY, 20, 15));
            }
            lX = 0;
        }
        lY = 450;
        for(int i = 0;i < SROW; i++){
            lY = lY + 25;
            for(int k = 0; k < SCOL; k++){
                if(i%2 == 0) {
                    SCOL = 12;
                    lX = (lX + getWidth()/13);
                }
                else{
                    SCOL = 15;
                    lX = (lX + getWidth()/16);
                }
                visuals.add(new Enemies(Color.GREEN, lX, lY, 10, 5));
            }
            lX = 0;
        }
    }

    public void checkCollisions(){
        for(int i = 0; i < visuals.size(); i++){
            for(int j = 0; j < visuals.size(); j++){
            }
            if (visuals.get(i) instanceof Attack) {
                if (((Attack) visuals.get(i)).isRemove()) {
                    visuals.remove(i);
                }
            }
        }
    }

    public void Shoot(){
            visuals.add(new Attack(Color.green, visuals.get(0).x, visuals.get(0).y, 5, 5));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < visuals.size(); i++) {
            visuals.get(i).paint(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        checkCollisions();

        visuals.get(0).move(getWidth(), getHeight());
        for(int i = 1;  i < visuals.size(); i++) {
            visuals.get(i).move(getWidth(), getHeight());
        }
        repaint();
    }
}
