package br.udesc.ceavi.controlller;

import br.udesc.ceavi.model.entity.AirplaneQueue;


/**
 *
 * @author lucas.adriano, felipe lana
 */
public class TowerControlConcrete implements TowerControl {
 
    private AirplaneQueue airplanes = new AirplaneQueue();


    @Override
    public void updateScores(AirplaneQueue airplaneQueue) {
        //TODO Balance the airplane queue based on the current status of the attributes of each airplane.
    }
}