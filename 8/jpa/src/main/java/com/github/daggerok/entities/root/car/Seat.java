package com.github.daggerok.entities.root.car;

import com.github.daggerok.entities.common.BaseEntity;
import com.github.daggerok.entities.root.car.seat.Belt;
import com.github.daggerok.entities.root.car.seat.Type;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import static com.github.daggerok.entities.root.car.seat.Type.FRONT;
import static javax.persistence.EnumType.STRING;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "seats")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = PROTECTED)
@RequiredArgsConstructor(staticName = "of")
public class Seat extends BaseEntity {

  @Enumerated(STRING)
  Type type = FRONT;

  @NonNull
  @Embedded
  Belt belt;
}
