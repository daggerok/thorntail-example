package com.github.daggerok.beans;

import lombok.Getter;
import lombok.ToString;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Stateful
@ToString(of = { "description", "uuid" })
public class StatefulHttpSessionScopedEjbBean implements Serializable {
  String description = StatefulHttpSessionScopedEjbBean.class.getSimpleName() + ": " + Stateless.class.getName();
  String uuid = UUID.randomUUID().toString();
}
