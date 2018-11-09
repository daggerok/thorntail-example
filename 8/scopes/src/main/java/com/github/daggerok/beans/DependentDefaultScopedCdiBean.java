package com.github.daggerok.beans;

import lombok.Getter;
import lombok.ToString;

import javax.enterprise.context.Dependent;

@Getter
@Dependent
@ToString(of = "description")
public class DependentDefaultScopedCdiBean {
  String description = DependentDefaultScopedCdiBean.class.getSimpleName() + ": " + Dependent.class.getName();
}
