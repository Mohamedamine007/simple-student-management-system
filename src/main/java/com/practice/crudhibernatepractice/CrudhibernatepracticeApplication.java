package com.practice.crudhibernatepractice;

import com.practice.crudhibernatepractice.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.practice.crudhibernatepractice.entity.Student;

import java.util.Scanner;

@SpringBootApplication
public class CrudhibernatepracticeApplication {

	Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {

		// define a scanner globally
		// so we can get the data from the user
		SpringApplication.run(CrudhibernatepracticeApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {

			System.out.println("**************** Student management system *****************");

			boolean notStoppedYet = true;
			int userInput;
			do {


				System.out.println("Add a student: 1");
				System.out.println("Display a student by its last name: 2");
				System.out.println("Display all students: 3");
				System.out.println("Update a student: 4");
				System.out.println("Remove a student: 5");
				System.out.println("Quit: 0");

				System.out.print("Enter your choice: ");
				userInput = scanner.nextInt();
				scanner.nextLine();
				switch(userInput) {

					case 1:

						addStudent(studentDAO);
						break;
					case 2:

						System.out.println("This functionality not added yet");
						break;
					case 3:

						System.out.println("This functionality not added yet");
						break;
					case 4:

						System.out.println("This functionality not added yet");
						break;
					case 5:

						System.out.println("This functionality not added yet");
						break;
					default:

						System.out.println("Good Bye");
						break;
				}


			}while(userInput != 0);
		};
	}

	private void addStudent(StudentDAO studentDAO) {

		System.out.println("Student first name: ");
		String firstName = scanner.nextLine();
		System.out.println("Student last name: ");
		String lastName = scanner.nextLine();
		System.out.println("Student email: ");
		String email = scanner.nextLine();

		Student studentToAdd = new Student(firstName, lastName, email);
		System.out.println("Adding student...");
		studentDAO.add(studentToAdd);
		System.out.println("Student added successfully");
	}
}



