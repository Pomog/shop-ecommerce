package com.shop.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.shop.common.entity.Role;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = Role.class)
public class ShopmebackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopmebackendApplication.class, args);
	}

}
