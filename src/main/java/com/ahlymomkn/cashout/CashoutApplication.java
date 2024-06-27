package com.ahlymomkn.cashout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class CashoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(CashoutApplication.class, args);
	}

}
