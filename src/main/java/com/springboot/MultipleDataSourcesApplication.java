package com.springboot;

import com.springboot.datasources.config.EmbeddedTomcatConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(EmbeddedTomcatConfiguration.class)
public class MultipleDataSourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipleDataSourcesApplication.class, args);
	}
}
