package br.udesc.ceavi.reader;

import br.udesc.ceavi.model.airplane.Airplane;

/**
 * @author lucas.adriano
 */
public interface ObserverReader {
 
    public void planeRead(Airplane plane);
}