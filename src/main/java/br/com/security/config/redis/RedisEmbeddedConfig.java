package br.com.security.config.redis;

import static redis.clients.jedis.Protocol.DEFAULT_HOST;
import static redis.clients.jedis.Protocol.DEFAULT_PORT;

import java.io.IOException;
import java.net.Socket;

import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.embedded.RedisServer;

@Configuration
public class RedisEmbeddedConfig {

	private RedisServer redisServer;

	@Bean
	public JedisConnectionFactory connectionFactory() throws IOException {
		this.redisServer = new RedisServer(DEFAULT_PORT);
		if (this.available()) {
			this.redisServer.start();
		}
		return new JedisConnectionFactory();
	}

	private boolean available() {
		try (final Socket socket = new Socket(DEFAULT_HOST, DEFAULT_PORT)) {
			return false;
		} catch (final IOException e) {
			return true;
		}
	}

	@PreDestroy
	void destroy() {
		this.redisServer.stop();
	}
}
