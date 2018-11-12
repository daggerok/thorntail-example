package com.github.daggerok.services;

import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ProcessInvocationTracker {

  @Inject
  Logger log;

  public void tackBefore() {
    log.info("setup 'man in a middle' tracker...");
  }

  public void tackResult(Object o) {
    log.info("logging result: {}", o);
  }
}
