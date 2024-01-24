package com.ubs.creditcard.creditcardvalidation;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class CreditCardValidationApplication {
	public static void main(String[] args) {
		log.info("Starting Credit Card Validation Application");

		SpringApplication.run(CreditCardValidationApplication.class, args);

	}

}
