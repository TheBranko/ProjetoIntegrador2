
package br.udesc.ceavi.view;

import br.udesc.ceavi.controlller.TowerControl;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.io.IOException;

/**
 *
 * @author Avell
 */
public class AeronauticalChart extends Applet {

    int width, height;

    @Override
    public void init() {
        this.setSize(1350, 650);
        width = getSize().width;
        height = getSize().height;
        
        System.out.println(width);
        System.out.println(height);
        setBackground(Color.black);
    }

    //1cm = 119px
    int[] xPista = {300, 118, 118, 300};
    int[] yPista = {300, 300, 100, 100};
    Polygon pista = new Polygon(xPista, yPista, 4);
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.green);

        g.drawPolygon(pista);
        
        Image image = getImage(AeronauticalChart.class.getClassLoader().getResource("br/udesc/ceavi/view/images/airplane.png"));
        g.drawImage(image, 500, 300, this);
        g.drawImage(image, 500, 200, this);
    }
    
//    public static void main(String[] args) throws IOException {
//        System.out.println("oi");
//        init();
//        TowerControl tc = new TowerControl();
//    }
}
