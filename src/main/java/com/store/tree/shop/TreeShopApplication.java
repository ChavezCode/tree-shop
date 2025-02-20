package com.store.tree.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@SpringBootApplication
public class TreeShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreeShopApplication.class, args);
	}

}
