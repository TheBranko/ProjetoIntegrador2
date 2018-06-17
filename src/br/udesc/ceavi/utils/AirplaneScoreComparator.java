package br.udesc.ceavi.utils;

import br.udesc.ceavi.model.airplane.Airplane;
import java.util.Comparator;

/**
 *
 * @author Avell
 */
public class AirplaneScoreComparator implements Comparator<Airplane> {

    @Override
    public int compare(Airplane o1, Airplane o2) {
        if (o1.getScore() == o2.getScore()) {
            return 0;
        }
        return o1.getScore() > o2.getScore() ? 1 : -1;
    }
}
