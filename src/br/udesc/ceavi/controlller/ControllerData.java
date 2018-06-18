package br.udesc.ceavi.controlller;

import br.udesc.ceavi.model.airplane.Airplane;
import br.udesc.ceavi.model.airplane.AirplaneBuilder;
import br.udesc.ceavi.model.airplane.AirplaneDirector;
import br.udesc.ceavi.model.routes.ApproachRouteBuilder;
import br.udesc.ceavi.model.routes.LandingRoute;
import br.udesc.ceavi.model.routes.LandingRouteBuilder;
import br.udesc.ceavi.model.routes.Route;
import br.udesc.ceavi.model.routes.RouteBuilder;
import br.udesc.ceavi.model.routes.RouteDirector;
import br.udesc.ceavi.model.routes.WaitingRouteBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Felipe Lana, Kevin Kons, Lucas Adriano, Jéssica
 */
public class ControllerData {

    private List<Route> approachRoutes = new ArrayList<>();
    private List<Route> waitingRoutes = new ArrayList<>();
    private List<LandingRoute> landingRoutes = new ArrayList<>();

    private AirplaneDirector airplaneDirector;
    private AirplaneBuilder airplaneBuilder;

    private RouteDirector routeDirector;
    private RouteBuilder routeBuilder;

    public ControllerData() throws IOException {
        airplaneBuilder = new AirplaneBuilder();
        airplaneDirector = new AirplaneDirector(airplaneBuilder);
        
        buildApproachRoutes();
        buildLandingRoutes();
    }

    public Airplane buildAirplane() throws IOException, Exception {
        Random random = new Random();
        

        if (airplaneBuilder.readLine()) {
            airplaneDirector.build(approachRoutes.remove(random.nextInt(approachRoutes.size() - 1)));
            try {
                return airplaneBuilder.getAirplane();
            } finally {
                airplaneBuilder.startsNewAirplane();
            }
        } else {
            throw new Exception("All airplanes in the 'airplanex.txt' file have already been detected");
        }
    }

//    private void buildAllAirplanes() throws IOException {
//        Random random = new Random();
//        airplaneBuilder = new AirplaneBuilder();
//        airplaneDirector = new AirplaneDirector(airplaneBuilder);
//
//        while (airplaneBuilder.readLine()) {
//            airplaneDirector.build(approachRoutes.get(random.nextInt(approachRoutes.size() - 1)));
//            airplanes.add(airplaneBuilder.getAirplane());
//            airplaneBuilder.startsNewAirplane();
//        }
//    }
    private void buildApproachRoutes() throws IOException {
        routeBuilder = new ApproachRouteBuilder();
        routeDirector = new RouteDirector(routeBuilder);

        while (routeBuilder.readLine()) {
            routeDirector.build();
            approachRoutes.add(routeBuilder.getRoute());
            routeBuilder.startNewRoute();
        }
    }

    private void buildLandingRoutes() throws IOException {
        routeBuilder = new LandingRouteBuilder();
        routeDirector = new RouteDirector(routeBuilder);

        while (routeBuilder.readLine()) {
            routeDirector.build();
            landingRoutes.add((LandingRoute) routeBuilder.getRoute());
            routeBuilder.startNewRoute();
        }

    }

    public LandingRoute getLandingRoute() {
        return landingRoutes.get(0);
    }

}
