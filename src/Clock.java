import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

import static java.lang.Math.*;

public class Clock extends JFrame implements ActionListener {
    public int xc = 100;
    public int yc = 200;
    public int r = 100;

    arrow sarrow = new arrow(xc,yc,100, 3, 60, Color.yellow);
    arrow marrow = new arrow(xc,yc,100, 5, 60, Color.red);
    arrow harrow = new arrow(xc,yc,70, 10, 12, Color.white);
    arrow rfjarrow = new arrow(xc-50,yc+5,70, 15, 50, Color.green);
    public Clock() {
        super("Clock");
        setBackground(Color.blue);
        setBounds(100,100,400,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Timer timer = new Timer(100,this);
        timer.setActionCommand("timer");
        timer.start();
    }
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0,0,400,400);
        g2d.setStroke(new BasicStroke(10));
        g2d.setColor(Color.MAGENTA);
        g2d.drawOval(xc-r,yc-r, 2*r,2*r);
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(Color.white);

        for(double i=0;i<360;i+=30) {
            double x1 = r*3/4*cos(i/180*PI)+xc;
            double y1 = r*3/4*sin(i/180*PI)+yc;
            double x2 = (r+5)*cos(i/180*PI)+xc;
            double y2 = (r+5)*sin(i/180*PI)+yc;
            g2d.drawLine((int)x1,(int)y1, (int) x2, (int) y2);

    }
        Calendar currentime = Calendar.getInstance();
        double sec = currentime.get(Calendar.SECOND);
        double hrs = currentime.get(Calendar.HOUR);
        double min = currentime.get(Calendar.MINUTE);
        double ms = currentime.get(Calendar.MILLISECOND);

        harrow.draw(g2d, hrs + min/60 + sec/3600);
        marrow.draw(g2d, min + sec/60);
        sarrow.draw(g2d,sec + ms/1000);




    }
double xyz = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
        xyz = xyz +6;
        this.repaint();
    }

}
