package daggerok.resources.car;

import daggerok.resources.car.domain.Car;

import javax.ejb.Stateless;
import java.util.UUID;

@Stateless
public class CarManufactorer {

  public Car create(Specification spec) {
    return new Car(spec.getEngineType(), spec.getColor(), UUID.randomUUID().toString());
  }
}
