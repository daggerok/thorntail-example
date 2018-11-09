package com.github.daggerok.beans;

import lombok.Getter;
import lombok.ToString;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import java.io.Serializable;

@Getter
@Stateless
@ToString(of = "description")
public class StatelessScopedPulledEjbBean implements Serializable {
  String description = StatelessScopedPulledEjbBean.class.getSimpleName() + ": " + Stateful.class.getName();
}
