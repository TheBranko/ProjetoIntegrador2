package br.udesc.ceavi.utils;

import br.udesc.ceavi.model.airplane.Airplane;
import java.util.Comparator;

/**
 *
 * @author Felipe Lana, Kevin Kons, Lucas Adriano, Jéssica
 */
public class AirplaneTimeComparator implements Comparator<Airplane>{

    @Override
    public int compare(Airplane o1, Airplane o2) {
        if(o1.getTimeToRouteEnd() == o2.getTimeToRouteEnd())
            return 0;
        return o1.getTimeToRouteEnd() > o2.getTimeToRouteEnd() ? 1 : -1;
    }
    
}
