package br.com.check.app.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Marker;
import org.slf4j.helpers.BasicMarkerFactory;
import org.springframework.context.annotation.Configuration;


@Configuration
@Aspect
@RequiredArgsConstructor
@Slf4j
public class AspectConfig {

  private static final String CONTROLLER =
      "execution(* br.com.check.app.controller.*.* (..))";
  private static final String SERVICE =
      "execution(* br.com.check.app.service.*.* (..))";
  private static final String BEFORE = "start the execution ";
  private static final String AFTER = "finishing the execution ";
  private static final String ERROR = "error found... ";
  private static final String WITH_VALUES = "with values: {}";
  private static final String WITHOUT_VALUES = "without values";

  @Before(CONTROLLER)
  public void beforeController(final JoinPoint joinPoint) {
    this.log(joinPoint.getSignature().getDeclaringType().getSimpleName()+ "." + joinPoint.getSignature().getName() + "() -> "+ BEFORE + (joinPoint.getArgs() != null ? WITH_VALUES : WITHOUT_VALUES), joinPoint,
        joinPoint.getArgs());
  }

  @Before(SERVICE)
  public void beforeService(final JoinPoint joinPoint) {
    this.log(joinPoint.getSignature().getDeclaringType().getSimpleName()+ "." + joinPoint.getSignature().getName() + "() -> "+ BEFORE + (joinPoint.getArgs() != null ? WITH_VALUES : WITHOUT_VALUES), joinPoint,
        joinPoint.getArgs());
  }

  @AfterReturning(pointcut = CONTROLLER, returning = "result")
  public void afterController(final JoinPoint joinPoint, final Object result) {
    this.log(joinPoint.getSignature().getDeclaringType().getSimpleName()+ "." + joinPoint.getSignature().getName() + "() -> "+ AFTER + (joinPoint.getArgs() != null ? WITH_VALUES : WITHOUT_VALUES), joinPoint,
        joinPoint.getArgs(), result);
  }

  @AfterReturning(pointcut = SERVICE, returning = "result")
  public void afterService(final JoinPoint joinPoint, final Object result) {
    this.log(joinPoint.getSignature().getDeclaringType().getSimpleName()+ "." + joinPoint.getSignature().getName() + "() -> "+ AFTER + (joinPoint.getArgs() != null ? WITH_VALUES : WITHOUT_VALUES), joinPoint,
        joinPoint.getArgs(), result);  }

  @AfterThrowing(pointcut = CONTROLLER, throwing = "ex")
  public void exception(final JoinPoint joinPoint, final Throwable ex) {
    final Marker marker =
        new BasicMarkerFactory().getMarker(joinPoint.getSignature().getDeclaringTypeName()
            + " -> " + joinPoint.getSignature().getName()
        );
    log.error(marker, ERROR, ex);

  }

  private void log(final String mensagem, final JoinPoint joinPoint, final Object... objects) {
    final Marker marker =
        new BasicMarkerFactory().getMarker(joinPoint.getSignature().getDeclaringTypeName()
            + " -> " + joinPoint.getSignature().getName()
        );
    log.info(marker, mensagem, objects);
  }
}