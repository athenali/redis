package com.railway.redis;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = {"com.railway.redis.*"})
public class RBPSEMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(RBPSEMSApplication.class, args);
		System.out.printf(
				"\n----------------------------------------------------------\n\t"
						+ "Application is running! Access URLs:\n\t"
						+ "Local: \t\thttp://localhost:8080\n\t"
						+ "\n----------------------------------------------------------\n"
				);
	}

}
