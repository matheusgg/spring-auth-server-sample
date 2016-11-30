package br.com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.sql.DataSource;

/**
 * Created by Matheus on 20/03/16.
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2ServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private DataSource dataSource;

//	@Autowired
//	private RedisConnectionFactory cf;

	@Override
	public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(this.authenticationManager);
		// endpoints.tokenStore(new RedisTokenStore(this.cf));
	}

	@Override
	public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
				.withClient("my-client-id")
				.secret("secret")
				.authorizedGrantTypes("authorization_code", "refresh_token", "implicit", "password", "client_credentials")
				.scopes("read", "write");

		// clients.jdbc(this.dataSource);
	}

	@Override
	public void configure(final AuthorizationServerSecurityConfigurer security) throws Exception {
		// security.passwordEncoder(new BCryptPasswordEncoder());
	}
}
