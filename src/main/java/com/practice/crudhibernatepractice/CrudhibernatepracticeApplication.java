package com.practice.crudhibernatepractice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class CrudhibernatepracticeApplication {

	public static void main(String[] args) {

		// define a scanner globally
		// so we can get the data from the user
		Scanner scanner = new Scanner(System.in);
		SpringApplication.run(CrudhibernatepracticeApplication.class, args);
	}


	public CommandLineRunner commandLineRunner(String[] args) {

		return runner -> {

			System.out.println("**************** Student management system *****************");
		};
	}
}



