package daggerok.resources;

import daggerok.resources.car.CarManufactorer;
import daggerok.resources.car.Specification;
import daggerok.resources.car.domain.Car;
import daggerok.resources.car.domain.Color;
import daggerok.resources.car.domain.EngineType;
import io.vavr.control.Try;

import javax.ejb.Stateless;
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
    return Response.ok(car).build();
  }
}
