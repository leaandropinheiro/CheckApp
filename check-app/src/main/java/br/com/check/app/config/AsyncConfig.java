package br.com.check.app.config;

import br.com.check.app.utils.Util;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskDecorator;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.task.DelegatingSecurityContextAsyncTaskExecutor;

@Configuration
@EnableAsync
@RequiredArgsConstructor
@Slf4j
public class AsyncConfig implements AsyncConfigurer {

  private static final int CORE_POOL_SIZE = 3;
  private static final int MAX_POOL_SIZE = 7;
  private static final int QUEUE_CAPACITY = 10;
  private static final String PREFIX = "check-app-";
  private final MessageSource messageSource;

  @Bean
  public DelegatingSecurityContextAsyncTaskExecutor taskExecutor() {
    final ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
    threadPoolTaskExecutor.setCorePoolSize(CORE_POOL_SIZE);
    threadPoolTaskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
    threadPoolTaskExecutor.setQueueCapacity(QUEUE_CAPACITY);
    threadPoolTaskExecutor.setThreadNamePrefix(PREFIX);
    threadPoolTaskExecutor.setTaskDecorator(this.taskDecorator());
    threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
    threadPoolTaskExecutor.initialize();
    return new DelegatingSecurityContextAsyncTaskExecutor(threadPoolTaskExecutor);
  }

  @Override
  public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
    return (ex, method, params) -> log.error(
        Util.translate(this.messageSource, "config.AsyncConfig.handler"),
        method.getName(), params, ex
    );
  }

  private TaskDecorator taskDecorator() {
    return runnable -> {
      final Map<String, String> contextMap = MDC.getCopyOfContextMap();
      return () -> {
        MDC.setContextMap(contextMap);
        runnable.run();
        MDC.clear();
      };
    };
  }
}
