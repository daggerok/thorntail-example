package com.github.daggerok.produces;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class EntityManagerProvider {

  @PersistenceContext
  EntityManager em;

  @Produces
  public EntityManager entityManager() {
    return em;
  }
}
