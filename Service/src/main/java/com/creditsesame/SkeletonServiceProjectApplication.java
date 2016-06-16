package com.creditsesame;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

/**
 	Just plain spring-boot configuration init file, it is very small as Spring-boot is clever enough to selfconfigure most of
 	things.
 	It is configured protobuf as the message converter for the controllers
 */
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class SkeletonServiceProjectApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SkeletonServiceProjectApplication.class);

	@Bean
	ProtobufHttpMessageConverter protobufHttpMessageConverter() {
		return new ProtobufHttpMessageConverter();
	}

	public static void main(String[] args) {
		SpringApplication.run(SkeletonServiceProjectApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		log.info("Starting up things");


		log.info("End of starting up app");
	}
}
