package com.klgs.rest.gameEngine.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class GameEngineWwwApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameEngineWwwApplication.class, args);
	}
}
