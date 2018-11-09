package com.github.daggerok.beans;

import lombok.Getter;
import lombok.ToString;

import javax.ejb.Singleton;
import java.io.Serializable;

@Getter
@Singleton
@ToString(of = "description")
public class SingletonApplicationScopedEjbBean implements Serializable {
  String description = SingletonApplicationScopedEjbBean.class.getSimpleName() + ": " + Singleton.class.getName();
}
