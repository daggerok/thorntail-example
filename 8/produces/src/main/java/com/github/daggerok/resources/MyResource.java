package com.github.daggerok.resources;

import com.github.daggerok.car.domain.Car;
import com.github.daggerok.car.domain.Color;
import com.github.daggerok.car.produces.CarExposer.*;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.stream.Stream;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("")
@Stateless
@Produces(APPLICATION_JSON)
public class MyResource {

  @Inject
  Logger log;

  @Inject
  Car defaultBlackCar;

  @Inject
  @RedCar
  Car redCar;

  @Inject
  @WhiteCar
  Car whiteCar;

  @GET
  @Consumes(APPLICATION_JSON)
  public Response getDefaultCar() {
    log.info("getDefaultCar");
    return Response.ok(defaultBlackCar).build();
  }

  @GET
  @Path("/{color}")
  @Consumes(APPLICATION_JSON)
  public Response getCarByColor(@PathParam("color") Color color) {
    log.info("getCarByColor");
    return Response.ok()
                   .entity(Stream.of(redCar, whiteCar, defaultBlackCar)
                                 .filter(car -> car.getColor() == color)
                                 .findFirst()
                                 .orElse(defaultBlackCar)) // this will never
                   .build();
  }
}
