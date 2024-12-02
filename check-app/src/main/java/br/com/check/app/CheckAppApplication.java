package br.com.check.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "br.com.check.app", exclude = {SecurityAutoConfiguration.class})
@EnableConfigurationProperties
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@EnableJpaRepositories
public class CheckAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckAppApplication.class, args);
	}

}
