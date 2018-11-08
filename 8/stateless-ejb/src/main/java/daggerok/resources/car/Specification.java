package daggerok.resources.car;

import daggerok.resources.car.domain.Color;
import daggerok.resources.car.domain.EngineType;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Specification {
  final Color color;
  final EngineType engineType;
}
