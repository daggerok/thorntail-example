package com.github.daggerok.entities.root.car.seat;

import com.github.daggerok.entities.root.car.seat.belt.Model;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Enumerated;

import static javax.persistence.EnumType.STRING;
import static lombok.AccessLevel.PROTECTED;

@Data
@Embeddable
@NoArgsConstructor(access = PROTECTED)
@RequiredArgsConstructor(staticName = "of")
public class Belt {

  @NonNull
  @Setter(PROTECTED)
  @Enumerated(STRING)
  Model model;

  public void open() { }

  public void closde() { }
}
