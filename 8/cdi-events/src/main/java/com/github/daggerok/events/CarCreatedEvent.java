package com.github.daggerok.events;

import com.github.daggerok.car.domain.Car;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor(staticName = "of")
public class CarCreatedEvent {
  final Car car;
}
