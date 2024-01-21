package com.practice.crudhibernatepractice;

import com.practice.crudhibernatepractice.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.practice.crudhibernatepractice.entity.Student;

import java.util.List;
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

				System.out.println("*************** MENU ****************");
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

						findStudentByLastName(studentDAO);
						break;
					case 3:

						findAllStudents(studentDAO);
						break;
					case 4:

						updateStudent(studentDAO);
						break;
					case 5:

						deleteStudent(studentDAO);
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

	private void findStudentByLastName(StudentDAO studentDAO) {

		System.out.println("Last name of searched student: ");
		String lastNameToSearch = scanner.nextLine();

		List<Student> searchedStudents = studentDAO.findByLastName(lastNameToSearch);

		if(!searchedStudents.isEmpty()) {

			for(Student student: searchedStudents) {
				System.out.println(student);
			}
		}else {

			System.out.println("Student " + lastNameToSearch + " not found");
		}
	}

	public void findAllStudents(StudentDAO studentDAO) {

		System.out.println("Searching for students...");

		List<Student> studentList = studentDAO.findAll();

		if(!studentList.isEmpty()) {

			System.out.println("There's is the students: ");
			for(Student student: studentList) {

				System.out.println(student);
			}
		}else {

			System.out.println("Students table is null");
		}
	}

	private void updateStudent(StudentDAO studentDAO) {

		System.out.println("Id of student to update: ");
		int idToUpdate = scanner.nextInt();
		scanner.nextLine();

		Student studentToUpdate = studentDAO.findById(idToUpdate);

		System.out.println("Enter new first name: ");
		String newFirstName = scanner.nextLine();
		studentToUpdate.setFirstName(newFirstName);

		System.out.println("Enter new last name: ");
		String newLastName = scanner.nextLine();
		studentToUpdate.setLastName(newLastName);

		System.out.println("Enter new email: ");
		String newEmail = scanner.nextLine();
		studentToUpdate.setEmail(newEmail);

		System.out.println("Updating informations...");
		studentDAO.update(studentToUpdate);
		System.out.println("Updated Successfully");
		System.out.println("New student infos: " + studentToUpdate);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		System.out.println("Id of the student to delete: ");
		int idToDelete = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Deleting student...");
		studentDAO.delete(idToDelete);
		System.out.println("Student deleted successfully");
	}
}



