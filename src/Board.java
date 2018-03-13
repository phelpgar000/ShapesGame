import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel implements ActionListener{

    Timer timer;
    List<Objects> visuals = new ArrayList<Objects>();

    int lX, lY, SCOL = 15;
    final int BCOL = 5, BROW = 1, NCOL = 8, NROW = 7, SROW = 5;

    public Board(){
        setPreferredSize(new Dimension(900, 800));
        setBackground(Color.BLACK);

        timer = new Timer(1000/60, this);
        timer.start();
    }

    public void setStage(){
        for(int i = 0; i < BROW; i++) {
            lY = lY + 75;
            for(int k = 0; k < BCOL; k++) {
                lX = (lX + getWidth()/6);
                visuals.add(0, new Enemies(Color.BLUE, lX, lY, 75, 25));
            }
            lX = 0;
        }
        lY = 75;
        for(int i = 0; i < NROW; i++){
            lY = lY + 50;
            for(int k = 0; k < NCOL; k++){
                lX = (lX + getWidth()/9);
                visuals.add(0, new Enemies(Color.RED, lX, lY, 20, 15));
            }
            lX = 0;
        }
        lY = 450;
        for(int i = 0;i < SROW; i++){
            lY = lY + 25;
            if(i%2 == 0) {
               SCOL = SCOL - 1;
               lX = (lX + getWidth()/15);
            }
            else{
                SCOL = 15;
                lX = (lX + getWidth()/16);
            }
            for(int k = 0; k < SCOL; k++){
                visuals.add(0, new Enemies(Color.GREEN, lX, lY, 10, 5));
            }
            lX = 0;
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < visuals.size(); i++) {
            visuals.get(i).paint(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
