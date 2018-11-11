package com.github.daggerok.entities;

import com.github.daggerok.entities.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car extends BaseEntity {

  @Enumerated(EnumType.STRING)
  Engine engine = Engine.DIESEL;

  @Enumerated(EnumType.STRING)
  Color color = Color.BLACK;
}
