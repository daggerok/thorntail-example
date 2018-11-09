package com.github.daggerok;

import com.github.daggerok.beans.*;
import com.github.daggerok.logs.LoggerProvider;
import com.github.daggerok.providers.ExceptionMapperProvider;
import com.github.daggerok.providers.JacksonProvider;
import com.github.daggerok.resources.MyResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

@ApplicationPath("")
public class RestApplication extends Application {
  @Override
  public Set<Class<?>> getClasses() {
    return new HashSet<>(asList(
        ExceptionMapperProvider.class,
        JacksonProvider.class,
        LoggerProvider.class,
        MyResource.class,

        DependentDefaultScopedCdiBean.class,
        ApplicationScopedCdiBean.class,
        SingletonApplicationScopedEjbBean.class,
        StatelessScopedPulledEjbBean.class,
        StatefulHttpSessionScopedEjbBean.class
    ));
  }
}
