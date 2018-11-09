package com.github.daggerok.car.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static lombok.AccessLevel.PACKAGE;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = PACKAGE)
public class Car {
  EngineType engineType;
  Color color;
  String id;
}
