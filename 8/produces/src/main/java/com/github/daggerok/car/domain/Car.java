package com.github.daggerok.car.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PACKAGE;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = PACKAGE)
public class Car {
  EngineType engineType;
  Color color;
  String id;
}
