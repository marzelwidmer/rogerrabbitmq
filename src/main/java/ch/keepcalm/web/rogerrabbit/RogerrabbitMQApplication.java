package ch.keepcalm.web.rogerrabbit;

import io.arivera.oss.embedded.rabbitmq.EmbeddedRabbitMq;
import io.arivera.oss.embedded.rabbitmq.EmbeddedRabbitMqConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RogerrabbitMQApplication {

	public static void main(String[] args) {
		EmbeddedRabbitMqConfig config = new EmbeddedRabbitMqConfig.Builder().build();
		EmbeddedRabbitMq rabbitMq = new EmbeddedRabbitMq(config);
		rabbitMq.start();
		SpringApplication.run(RogerrabbitMQApplication.class, args);
	}
}
