package br.com.check.app.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageConfig {

  private static final String ENCODING = "UTF-8";

  @Bean
  public MessageSource messageSource() {
    final ReloadableResourceBundleMessageSource resource =
        new ReloadableResourceBundleMessageSource();

    resource.setDefaultEncoding(ENCODING);
    resource.setBasenames("classpath:messages");

    return resource;
  }

}
