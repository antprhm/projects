import java.awt.*;
import java.lang.Math.*;

import static java.lang.Math.*;

public class arrow {
    int cx = 0;
    int cy = 0;
    int alength;
    int awidth;
    int atime;
    Color color;

    public arrow (int cx, int cy, int alength,int awidth, int atime, Color color) {
        this.cx = cx;
        this.cy = cy;
        this.alength = alength;
        this.awidth = awidth;
        this.atime = atime;
        this.color = color;
    }
    public void draw(Graphics2D g2d, double time) {
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(awidth));
        double xyz = 360/atime*time;
        xyz = xyz - 90;
        double x1 = -alength*1/4*cos(xyz/180*PI)+cx;
        double y1 = -alength*1/4*sin(xyz/180*PI)+cy;
        double x2 = (alength+5)*cos(xyz/180*PI)+cx;
        double y2 = (alength+5)*sin(xyz/180*PI)+cy;
        g2d.drawLine((int)x1,(int)y1, (int) x2, (int) y2);



    }


}
