package com.stc.cfgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value={ServiceConfig.class,PersistenceConfig.class,AopConfig.class})
public class RootConfig {

	public static void main(String[] args) {
		SpringApplication.run(RootConfig.class, args);
	}
}
