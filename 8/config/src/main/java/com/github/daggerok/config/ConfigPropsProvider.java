package com.github.daggerok.config;

import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@ApplicationScoped
public class ConfigPropsProvider {

  @Inject
  Logger log;

  Properties properties;

  @PostConstruct
  private void readConfigs() {
    try (InputStream inputStream = ConfigPropsProvider.class.getResourceAsStream("/application.properties")) {
      properties = new Properties();
      properties.load(inputStream);
    } catch (IOException e) {
      log.error("wasn't able read configs: {}", e.getLocalizedMessage(), e);
    }
  }

  @Produces
  @Config("unused")
  public String config(InjectionPoint injectionPoint) {
    final String key = injectionPoint.getAnnotated().getAnnotation(Config.class).value();
    return properties.getProperty(key, "undefined");
  }
}
