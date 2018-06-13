package br.udesc.ceavi.controlller;

import br.udesc.ceavi.model.airplane.Airplane;
import br.udesc.ceavi.model.airplane.visitorAirplane.CalculateAccelerarionVisitor;
import br.udesc.ceavi.model.airplane.visitorAirplane.CalculateNewPosition;
import br.udesc.ceavi.model.airplane.visitorAirplane.CalculateSpeedVisitor;
import br.udesc.ceavi.model.airplane.visitorAirplane.CalculateTimeToRouteEndVisitor;
import br.udesc.ceavi.model.airplane.visitorAirplane.VisitorAirplane;
import br.udesc.ceavi.model.routes.Coordinate;
import br.udesc.ceavi.utils.AirplaneScoreComparator;
import br.udesc.ceavi.utils.AirplaneTimeComparator;
import br.udesc.ceavi.utils.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lucas.adriano, Kevin Kons
 */
public class TowerControl {

    private ControllerData data;

    private List<Airplane> scoreList = new ArrayList<>(10);
    private List<Airplane> timeList = new ArrayList<>(10);

    public TowerControl() throws IOException, Exception {
        data = new ControllerData();

        for (int i = 0; i < 5; i++) {
            Airplane a = data.buildAirplane();
            scoreList.add(a);
            timeList.add(a);
        }

        while (!scoreList.isEmpty() && !timeList.isEmpty()) {
            scoreList.sort(new AirplaneScoreComparator());
            timeList.sort(new AirplaneTimeComparator());
            
            //Garante que as duas Lists estejam ordenadas da igualmente
            for (int i = 0; i < timeList.size(); i++) {
                Airplane airplaneByScore = scoreList.get(i);
                Airplane airplaneByTime = timeList.get(i);

                if (airplaneByScore != airplaneByTime) {
                    double scoreListTime = airplaneByScore.getTimeToRouteEnd();

                    VisitorAirplane calculateAcceleration = new CalculateAccelerarionVisitor();
                    double newTimeToRouteEnd = scoreListTime + 15;
                    airplaneByTime.accept(calculateAcceleration, newTimeToRouteEnd);
                    airplaneByTime.setAcceleration((double) calculateAcceleration.getValue());

                    for (int j = i + 1; i < timeList.size(); j++) {
                        Airplane airplaneTimeList = timeList.get(j);
                        if (airplaneTimeList != airplaneByScore) {
                            newTimeToRouteEnd = newTimeToRouteEnd + 15;
                            airplaneTimeList.accept(calculateAcceleration, newTimeToRouteEnd);
                            airplaneTimeList.setAcceleration((double) calculateAcceleration.getValue());
                        }
                    }
                }
            }
//            
//            for(Airplane a : scoreList) {
//                System.out.println(a.getId());
//            }
//            System.out.println("-------------");
//            for(Airplane a : timeList) {
//                System.out.println(a.getId());
//            }
//            break;
            
            //Move atualiza informações dos aviões
            for (Airplane a : timeList) {
                VisitorAirplane calculateNewPosition = new CalculateNewPosition();
                a.accept(calculateNewPosition, Utils.getInstance().getUpdateInterval());
                a.setCurrentLocation((Coordinate) calculateNewPosition.getValue());
                
                VisitorAirplane calculateSpeed = new CalculateSpeedVisitor();
                a.accept(calculateSpeed);
                a.setCurrentSpeed((double) calculateSpeed.getValue());
                
                VisitorAirplane calculateTimeToRouteEnd = new CalculateTimeToRouteEndVisitor();
                a.accept(calculateTimeToRouteEnd);
                a.setTimeToRouteEnd((double) calculateTimeToRouteEnd.getValue());
            }
        }
    }
}
