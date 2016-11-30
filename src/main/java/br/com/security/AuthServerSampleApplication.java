package br.com.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Ref.:
 * http://callistaenterprise.se/blogg/teknik/2015/05/20/blog-series-building-microservices/
 * http://callistaenterprise.se/blogg/teknik/2015/04/27/building-microservices-part-3-secure-APIs-with-OAuth/
 */
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableResourceServer
public class AuthServerSampleApplication {

	public static void main(final String[] args) {
		SpringApplication.run(AuthServerSampleApplication.class, args);
	}
}
