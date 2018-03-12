import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel implements ActionListener{

    Timer timer;
    List<Objects> visuals = new ArrayList<Objects>();

    final int armySize = 30;

    public Board(){
        setPreferredSize(new Dimension(900, 800));
        setBackground(Color.BLACK);

        timer = new Timer(1000/60, this);
        timer.start();
    }

    public void setStage(){
        for(int i = 0; i < armySize; i++) {
            int num1 = (int)(Math.random()*5)+1;
            int num2 = (int)(Math.random()*5)+1;
            visuals.add(0, new Enemies(Color.GREEN, getWidth() / num1, getHeight() / num2, 5, 10));
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
