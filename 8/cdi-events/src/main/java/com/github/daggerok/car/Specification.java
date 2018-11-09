package com.github.daggerok.car;

import com.github.daggerok.car.domain.Color;
import com.github.daggerok.car.domain.EngineType;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Specification {
  final Color color;
  final EngineType engineType;
}
