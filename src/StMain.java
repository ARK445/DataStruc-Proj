import java.util.InputMismatchException;
import java.util.Scanner;

public class StMain{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n===== Main Menu =====");
            System.out.println("1. School");
            System.out.println("2. Program");
            System.out.println("3. Curriculum");
            System.out.println("4. Course");
            System.out.println("5. Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            // Trap non-integer inputs for menu choice
            try {
                choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();  // Clear the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter school name: ");
                        String schoolName = scanner.nextLine();
                        System.out.print("Enter school address: ");
                        String schoolAddress = scanner.nextLine();
                        School school = new School(schoolName, schoolAddress);
                        school.displayDetails();
                    } catch (Exception e) {
                        System.out.println("An error occurred while entering school details: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Enter program name: ");
                        String programName = scanner.nextLine();
                        System.out.print("Enter program description: ");
                        String programDescription = scanner.nextLine();
                        Program program = new Program(programName, programDescription);
                        program.displayDetails();
                    } catch (Exception e) {
                        System.out.println("An error occurred while entering program details: " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.print("Enter curriculum title: ");
                        String curriculumTitle = scanner.nextLine();
                        System.out.print("Enter curriculum version: ");
                        String curriculumVersion = scanner.nextLine();
                        Curriculum curriculum = new Curriculum(curriculumTitle, curriculumVersion);
                        curriculum.displayDetails();
                    } catch (Exception e) {
                        System.out.println("An error occurred while entering curriculum details: " + e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        System.out.print("Enter course name: ");
                        String courseName = scanner.nextLine();

                        int credits = 0;
                        boolean validCredits = false;
                        while (!validCredits) {
                            System.out.print("Enter course credits: ");
                            try {
                                credits = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                validCredits = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid number for credits.");
                                scanner.nextLine(); // Clear invalid input
                            }
                        }

                        // Ask user if they want to associate a program with the course
                        System.out.print("Do you want to assign a program to this course? (yes/no): ");
                        String assignProgram = scanner.nextLine();
                        Course course;
                        if (assignProgram.equalsIgnoreCase("yes")) {
                            System.out.print("Enter program name: ");
                            String progName = scanner.nextLine();
                            System.out.print("Enter program description: ");
                            String progDescription = scanner.nextLine();
                            Program courseProgram = new Program(progName, progDescription);
                            course = new Course(courseName, credits, courseProgram);
                        } else {
                            course = new Course(courseName, credits);
                        }
                        course.displayDetails();
                    } catch (Exception e) {
                        System.out.println("An error occurred while entering course details: " + e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        System.out.print("Enter student name: ");
                        String studentName = scanner.nextLine();

                        int studentAge = 0;
                        while (true) {
                            System.out.print("Enter student age: ");
                            try {
                                studentAge = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid age.");
                                scanner.nextLine(); // Clear invalid input
                            }
                        }

                        int studentId = 0;
                        while (true) {
                            System.out.print("Enter student ID number: ");
                            try {
                                studentId = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid ID number.");
                                scanner.nextLine(); // Clear invalid input
                            }
                        }

                        System.out.print("Enter student address: ");
                        String studentAddress = scanner.nextLine();
                        System.out.print("Enter student course: ");
                        String studentCourse = scanner.nextLine();

                        Student student = new Student(studentName, studentAge, studentId, studentAddress, studentCourse);
                        student.displayDetails();

                        // Optionally update student details using setters
                        System.out.println("\nWould you like to update the student's name and course? (yes/no)");
                        String update = scanner.nextLine();
                        if (update.equalsIgnoreCase("yes")) {
                            System.out.print("Enter new name: ");
                            student.setName(scanner.nextLine());
                            System.out.print("Enter new course: ");
                            student.setCourse(scanner.nextLine());
                            student.displayDetails();
                        }
                    } catch (Exception e) {
                        System.out.println("An error occurred while entering student details: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Exiting the application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 6.");
            }

        } while (choice != 6);

        scanner.close();
    }
}
