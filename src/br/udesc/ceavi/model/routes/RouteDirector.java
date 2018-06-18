
package br.udesc.ceavi.model.routes;

import java.io.IOException;

/**
 *
 * @author Felipe Lana, Kevin Kons, Lucas Adriano, Jéssica
 */
public class RouteDirector {
    
    private RouteBuilder builder;

    public RouteDirector(RouteBuilder routeBuilder) {
        this.builder = routeBuilder;
    }
    
    public void build() throws IOException {
        builder.buildEntryLocation();
        builder.buildExitLocation();
        builder.buildEntrySpeed();
        builder.buildExitSpeed();
        builder.buildLength();
    }
    
}
