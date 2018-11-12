package com.github.daggerok.entities.root;

import com.github.daggerok.entities.common.BaseEntity;
import com.github.daggerok.entities.root.car.Color;
import com.github.daggerok.entities.root.car.Engine;
import com.github.daggerok.entities.root.car.Seat;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static com.github.daggerok.entities.root.car.Engine.DIESEL;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.EAGER;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "cars")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = PROTECTED)
@RequiredArgsConstructor(staticName = "of")
public class Car extends BaseEntity {

  @Enumerated(STRING)
  Engine engine = DIESEL;

  @NonNull
  @Enumerated(STRING)
  Color color;

  @OneToMany(cascade = ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "car", nullable = false)
  Set<Seat> seats = new HashSet<>();
}
