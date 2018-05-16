package br.udesc.ceavi.controlller;

import br.udesc.ceavi.model.airplane.Airplane;
import br.udesc.ceavi.model.airplane.AirplaneBuilder;
import br.udesc.ceavi.model.airplane.AirplaneDirector;
import br.udesc.ceavi.model.routes.ApproachRouteBuilder;
import br.udesc.ceavi.model.routes.LandingRouteBuilder;
import br.udesc.ceavi.model.routes.Route;
import br.udesc.ceavi.model.routes.RouteBuilder;
import br.udesc.ceavi.model.routes.RouteDirector;
import br.udesc.ceavi.model.routes.WaitingRouteBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author lucas.adriano
 */
public class TowerControl {

    private List<Route> routes = new ArrayList<>();
    private List<Route> approachRoutes = new ArrayList<>();
    private PriorityQueue<Airplane> planes = new PriorityQueue();

    private AirplaneDirector airplaneDirector;
    private AirplaneBuilder airplaneBuilder;

    private RouteDirector routeDirector;
    private RouteBuilder routeBuilder;

    public TowerControl() throws IOException {
        buildApproachRoutes();
        buildAirplanes();
//        buildWaitingRoutes();
//        buildLandingRoutes();
//        printRoutes();
        printAirplanes();
    }

    private void buildAirplanes() throws IOException {
        Random random = new Random();
        airplaneBuilder = new AirplaneBuilder();
        airplaneDirector = new AirplaneDirector(airplaneBuilder);
        
        while (airplaneBuilder.readLine()) {
            airplaneDirector.build(approachRoutes.get(random.nextInt(approachRoutes.size() - 1)));
            planes.add(airplaneBuilder.getAirplane());
            airplaneBuilder.startsNewAirplane();
        }
    }

    private void buildApproachRoutes() throws IOException {
        routeBuilder = new ApproachRouteBuilder();
        routeDirector = new RouteDirector(routeBuilder);

        while (routeBuilder.readLine()) {
            routeDirector.build();
            approachRoutes.add(routeBuilder.getRoute());
            routeBuilder.startsNewRoute();
        }

    }

    private void buildWaitingRoutes() throws IOException {
        routeBuilder = new WaitingRouteBuilder();
        routeDirector = new RouteDirector(routeBuilder);

        while (routeBuilder.readLine()) {
            routeDirector.build();
            routes.add(routeBuilder.getRoute());
            routeBuilder.startsNewRoute();
        }
    }

    private void buildLandingRoutes() throws IOException {
        routeBuilder = new LandingRouteBuilder();
        routeDirector = new RouteDirector(routeBuilder);

        while (routeBuilder.readLine()) {
            routeDirector.build();
            routes.add(routeBuilder.getRoute());
            routeBuilder.startsNewRoute();
        }

    }

    private void printRoutes() {
        for (Route r : approachRoutes) {
            System.out.println(r.getEntryLocation() + " " + r.getExitLocation() + " " + r.getEntrySpeed() + " " + r.getExitSpeed());
        }
    }

    private void printAirplanes() {
        for(Airplane a : planes) {
            System.out.println(a.getFuelCapacity() + " " + a.getAverageFuel() + " " + a.getCurrentSpeed() + " " + a.getCurrentLocation() + " " + a.getCurrentHeight() + " " + a.getRoute().getEntryLocation().toString());
        }
    }

}
