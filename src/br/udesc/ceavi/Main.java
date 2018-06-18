package br.udesc.ceavi;

import br.udesc.ceavi.controlller.TowerControl;
import java.io.IOException;

/**
 * @author Felipe Lana, Kevin Kons, Lucas Adriano, Jéssica
 */
public class Main {

    public static void main(String[] args) {
        try {
            new TowerControl();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
