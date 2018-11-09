package com.github.daggerok.beans;

import lombok.Getter;
import lombok.ToString;

import javax.enterprise.context.ApplicationScoped;

@Getter
@ApplicationScoped
@ToString(of = "description")
public class ApplicationScopedCdiBean {
  String description = ApplicationScopedCdiBean.class.getSimpleName() + ": " + ApplicationScoped.class.getName();
}
