import javax.swing.*;
import javax.swing.text.EditorKit;
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

    int lX, lY, x, y, SCOL = 15, NCOL = 8, bullets;
    final int BCOL = 5, BROW = 1, NROW = 7, SROW = 5;
    int army = SCOL*NCOL+SROW*NROW+BCOL*BROW;
    private long lastMoment, currentMoment;

    private final int DECORSIZE = 25;

    public Board(){
        setPreferredSize(new Dimension(900, 800));
        setBackground(Color.BLACK);

        timer = new Timer(1000/60, this);
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
        timer.start();
        lastMoment = System.currentTimeMillis();
    }

    public void checkCollisions(){
        for(int i = 0; i < visuals.size(); i++){
            for(int j = 0; j < visuals.size(); j++){
                if(visuals.get(i) instanceof Attack && visuals.get(j) instanceof Enemies){
                    if(visuals.get(i).collidesWith(visuals.get(j))) {
                        visuals.remove(j);
                        j = 0;
                        visuals.remove(i);
                        i = 0;
                        Stats.increaseScore();
                    }
                }
                if(visuals.get(i) instanceof Hurt && visuals.get(j) instanceof Player){
                    if(visuals.get(i).collidesWith(visuals.get(j))) {
                        Stats.decreaseScore();
                    }
                }
            }
            if (visuals.get(i) instanceof Attack) {
                if (((Attack) visuals.get(i)).isRemove()) {
                    visuals.remove(i);
                }
            }
            if (visuals.get(i) instanceof Hurt) {
                if (((Hurt) visuals.get(i)).isRemove()) {
                    visuals.remove(i);
                }
            }
        }
    }

    public void Shoot(){
            visuals.add(new Attack(Color.green, visuals.get(0).x + visuals.get(0).width/2, visuals.get(0).y + visuals.get(0).height/2, 5, 5));
            bullets++;
    }

    public void eShoot(){
        for(int i = 1;  i < visuals.size(); i++) {
            if (visuals.get(i) instanceof Enemies) {
                visuals.add(new Hurt(Color.pink, visuals.get(i).x + visuals.get(i).width/2, visuals.get(i).y + visuals.get(i).height/2, 5, 5));
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < visuals.size(); i++) {
            visuals.get(i).paint(g);
        }
        g.setColor(Color.GRAY);
        g.setFont(new Font("Serif", Font.BOLD, 72));
        printSimpleString(Stats.getScore().toString(), getWidth(), 0, DECORSIZE*2, g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        checkCollisions();
        currentMoment = System.currentTimeMillis();
        if(currentMoment - lastMoment > 4000) {
            eShoot();
            lastMoment = System.currentTimeMillis();
        }

        visuals.get(0).move(getWidth(), getHeight());
        for(int i = 1;  i < visuals.size(); i++) {
            if(visuals.get(i) instanceof Attack || visuals.get(i) instanceof Hurt){
                visuals.get(i).move(getWidth(), getHeight());
            }
        }
        repaint();
    }
    private void printSimpleString(String s, int width, int XPos, int YPos, Graphics g2d){
        int stringLen = (int)g2d.getFontMetrics().getStringBounds(s, g2d).getWidth();
        int start = width/2 - stringLen/2;
        g2d.drawString(s, start + XPos, YPos);
    }

}
