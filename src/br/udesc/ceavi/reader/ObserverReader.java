package br.udesc.ceavi.reader;

import br.udesc.ceavi.model.airplane.Airplane;

/**
 * @author Felipe Lana, Kevin Kons, Lucas Adriano, Jéssica
 */
public interface ObserverReader {
 
    public void planeRead(Airplane plane);
}