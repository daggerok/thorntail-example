package com.github.daggerok.resources;

import com.github.daggerok.car.CarManufactorer;
import com.github.daggerok.car.Specification;
import com.github.daggerok.car.domain.Car;
import com.github.daggerok.car.domain.Color;
import com.github.daggerok.car.domain.EngineType;
import com.github.daggerok.events.CarCreatedEvent;
import io.vavr.control.Try;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("")
@Stateless
@Produces(APPLICATION_JSON)
public class MyResource {

  @Inject
  CarManufactorer carManufactorer;

  @Inject
  Event<CarCreatedEvent> events;

  @POST
  @Consumes(APPLICATION_JSON)
  public Response hello(JsonObject json) {
    final Color color = Try.of(() -> Color.valueOf(json.getString("color")))
                           .getOrElseGet(throwable -> Color.red);
    final EngineType engineType = Try.of(() -> EngineType.valueOf(json.getString("engineType")))
                                     .getOrElseGet(throwable -> EngineType.fuel);
    final Specification specification = Specification.builder()
                                                     .color(color)
                                                     .engineType(engineType)
                                                     .build();
    final Car car = carManufactorer.create(specification);

    events.fire(CarCreatedEvent.of(car));
    return Response.ok(car).build();
  }
}
