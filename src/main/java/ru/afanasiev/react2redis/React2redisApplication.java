package ru.afanasiev.react2redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;

@SpringBootApplication(exclude = {R2dbcAutoConfiguration.class})
public class React2redisApplication {

	public static void main(String[] args) {
		SpringApplication.run(React2redisApplication.class, args);
	}

}
