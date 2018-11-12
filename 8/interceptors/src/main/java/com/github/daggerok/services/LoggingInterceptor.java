package com.github.daggerok.services;

import org.slf4j.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class LoggingInterceptor {

  @Inject
  Logger log;

  @Inject
  ProcessInvocationTracker processTracker;

  @AroundInvoke
  public Object aroundLogic(InvocationContext invocationContext) throws Exception {
    processTracker.tackBefore();
    final Object result = invocationContext.proceed();
    processTracker.tackResult(result);
    return result;
  }
}
