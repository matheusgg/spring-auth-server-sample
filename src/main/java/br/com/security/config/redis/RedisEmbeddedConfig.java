package br.com.security.config.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.Protocol;
import redis.embedded.RedisServer;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Matheus on 20/03/16.
 */
//@Configuration
public class RedisEmbeddedConfig {

	private RedisServer redisServer;

	@Bean
	public JedisConnectionFactory connectionFactory() throws IOException {
		this.redisServer = new RedisServer(Protocol.DEFAULT_PORT);
		if (this.available()) {
			this.redisServer.start();
		}
		return new JedisConnectionFactory();
	}

	private boolean available() {
		try (final Socket socket = new Socket(Protocol.DEFAULT_HOST, Protocol.DEFAULT_PORT)) {
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
