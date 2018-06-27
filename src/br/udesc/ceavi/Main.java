package br.udesc.ceavi;

import br.udesc.ceavi.controlller.TowerControl;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Felipe Lana, Kevin Kons, Lucas Adriano, Jéssica
 */
public class Main {
    
    public static JPanel panel;

    public static void main(String[] args) {
        try {
            
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setSize(600, 600);
            
            panel = new JPanel() {
                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(Color.WHITE);
                    g.fillRect(0, 0, 600, 600);
                    g.setColor(Color.BLACK);
                    g.fillOval(293, 275, 10, 10);
                }
                
            };
            frame.add(panel);
        
            new TowerControl();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}