package daggerok.resources.car.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PACKAGE;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = PACKAGE)
public class Car {
  EngineType engineType;
  Color color;
  String id;
}
