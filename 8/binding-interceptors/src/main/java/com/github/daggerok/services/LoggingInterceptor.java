package com.github.daggerok.services;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.function.Function;

import static com.github.daggerok.services.TrackingType.ACTIVE;
import static java.util.Arrays.asList;
import static javax.interceptor.Interceptor.Priority.APPLICATION;

@Track
@Interceptor
@Priority(APPLICATION) // Interceptor binding activation by using application priority
// or define in bean.xml: //interceptors/class/LoggingInterceptor.class FQDN
public class LoggingInterceptor {

  @Inject
  ProcessInvocationTracker processTracker;

  @AroundInvoke
  public Object aroundLogic(InvocationContext invocationContext) throws Exception {
    processTracker.tackBefore();
    final Object result = invocationContext.proceed();
    final Track track = getAnnotation(invocationContext);
    if (null != track && asList(track.value()).contains(ACTIVE)) {
      processTracker.tackResult(result);
    }
    return result;
  }

  private Track getAnnotation(InvocationContext invocationContext) {
    final Method method = invocationContext.getMethod();
    final Function<AnnotatedElement, Track> extractor = ae -> ae.getAnnotation(Track.class);
    final Track annotation = extractor.apply(method);
    return null != annotation ? annotation : extractor.apply(method.getDeclaringClass());
  }
}
