package com.engieapp.buy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.engieapp.buy.repository")

@SpringBootApplication
public class ShopingEngieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopingEngieApplication.class, args);
	}
}
