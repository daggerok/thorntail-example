package com.github.daggerok.car.produces;

import com.github.daggerok.car.domain.Car;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.github.daggerok.car.domain.Color.*;
import static com.github.daggerok.car.domain.EngineType.fuel;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@ApplicationScoped
public class CarExposer {

  @Produces
  Car defaultBlackCar = new Car(fuel, black, "000000000000-0000-0000-0000-00000000");

  @RedCar
  @Produces
  Car redCar = new Car(defaultBlackCar.getEngineType(), red, defaultBlackCar.getId());

  @Produces
  @WhiteCar
  Car whiteCar = new Car(defaultBlackCar.getEngineType(), white, defaultBlackCar.getId());

  @Qualifier
  @Documented
  @Retention(RUNTIME)
  public @interface RedCar { }

  @Qualifier
  @Documented
  @Retention(RUNTIME)
  public @interface WhiteCar { }
}
