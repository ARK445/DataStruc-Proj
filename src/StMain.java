import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StMain {
    public static void main(String[] args) {
        ArrayList<School> schools = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n===== Main Menu =====");
            System.out.println("1. Create Campus and Manage Campus Details");
            System.out.println("2. Display All Campuses");
            System.out.println("3. Delete an Item");
            System.out.println("4. Enroll Student");
            System.out.println("5. Update an Item");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    // Create Campus
                    System.out.print("Enter campus name: ");
                    String campusName = scanner.nextLine();
                    System.out.print("Enter campus address: ");
                    String campusAddress = scanner.nextLine();
                    School campus = new School(campusName, campusAddress);

                    // Campus management sub-menu
                    int subChoice = 0;
                    do {
                        System.out.println("\n--- Campus Management for " + campus.getName() + " ---");
                        System.out.println("1. Create Program for this campus");
                        System.out.println("2. Create Curriculum for this campus");
                        System.out.println("3. Create Course for this campus");
                        System.out.println("4. Display Courses for this campus");
                        System.out.println("5. Exit Campus Management");
                        System.out.print("Enter your choice: ");
                        try {
                            subChoice = scanner.nextInt();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input.");
                            scanner.nextLine();
                            continue;
                        }

                        switch (subChoice) {
                            case 1:
                                System.out.print("Enter program name: ");
                                String progName = scanner.nextLine();
                                System.out.print("Enter program description: ");
                                String progDesc = scanner.nextLine();
                                Program prog = new Program(progName, progDesc);
                                campus.addProgram(prog);
                                System.out.println("Program added to campus.");
                                break;
                            case 2:
                                System.out.print("Enter curriculum title: ");
                                String currTitle = scanner.nextLine();
                                System.out.print("Enter curriculum version: ");
                                String currVersion = scanner.nextLine();
                                Curriculum curr = new Curriculum(currTitle, currVersion);
                                campus.addCurriculum(curr);
                                System.out.println("Curriculum added to campus.");
                                break;
                            case 3:
                                System.out.print("Enter course name: ");
                                String courseName = scanner.nextLine();
                                int credits = 0;
                                boolean validCredits = false;
                                while (!validCredits) {
                                    System.out.print("Enter course credits: ");
                                    try {
                                        credits = scanner.nextInt();
                                        scanner.nextLine();
                                        validCredits = true;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Please enter a number.");
                                        scanner.nextLine();
                                    }
                                }
                                Course course = new Course(courseName, credits);
                                campus.addCourse(course);
                                System.out.println("Course added to campus.");
                                break;
                            case 4:
                                System.out.println("Courses for campus " + campus.getName() + ":");
                                if (campus.getCourses().isEmpty()) {
                                    System.out.println("No courses available.");
                                } else {
                                    for (Course c : campus.getCourses()) {
                                        c.displayDetails();
                                    }
                                }
                                break;
                            case 5:
                                System.out.println("Exiting Campus Management...");
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    } while(subChoice != 5);

                    schools.add(campus);
                    System.out.println("Campus created successfully!");
                    campus.displayDetails();
                    break;

                case 2:
                    // Display all campuses (with basic details)
                    if (schools.isEmpty()) {
                        System.out.println("No campuses available.");
                    } else {
                        for (School s : schools) {
                            s.displayDetails();
                        }
                    }
                    break;

                case 3:
                    // Delete an Item
                    System.out.println("Delete Options:");
                    System.out.println("1. Delete Campus");
                    System.out.println("2. Delete Enrolled Student");
                    System.out.print("Enter your choice: ");
                    int delChoice = 0;
                    try {
                        delChoice = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Returning to main menu.");
                        scanner.nextLine();
                        break;
                    }
                    if (delChoice == 1) {
                        if (schools.isEmpty()) {
                            System.out.println("No campuses to delete.");
                        } else {
                            System.out.println("Select a campus to delete:");
                            for (int i = 0; i < schools.size(); i++) {
                                System.out.println("[" + i + "] " + schools.get(i).getName());
                            }
                            int idx = scanner.nextInt();
                            scanner.nextLine();
                            if (idx >= 0 && idx < schools.size()) {
                                School removed = schools.remove(idx);
                                System.out.println("Deleted campus: " + removed.getName());
                            } else {
                                System.out.println("Invalid index.");
                            }
                        }
                    } else if (delChoice == 2) {
                        if (students.isEmpty()) {
                            System.out.println("No enrolled students to delete.");
                        } else {
                            System.out.println("Select a student to delete:");
                            for (int i = 0; i < students.size(); i++) {
                                System.out.println("[" + i + "] " + students.get(i).getName());
                            }
                            int idx = scanner.nextInt();
                            scanner.nextLine();
                            if (idx >= 0 && idx < students.size()) {
                                Student removed = students.remove(idx);
                                System.out.println("Deleted student: " + removed.getName());
                            } else {
                                System.out.println("Invalid index.");
                            }
                        }
                    } else {
                        System.out.println("Invalid deletion option.");
                    }
                    break;

                case 4:
                    // Enroll Student
                    if (schools.isEmpty()) {
                        System.out.println("No campuses available for enrollment.");
                        break;
                    }
                    System.out.println("Select a campus for enrollment:");
                    for (int i = 0; i < schools.size(); i++) {
                        System.out.println("[" + i + "] " + schools.get(i).getName());
                    }
                    int campusIndex = -1;
                    try {
                        campusIndex = scanner.nextInt();
                        scanner.nextLine();
                        if (campusIndex < 0 || campusIndex >= schools.size()) {
                            System.out.println("Invalid campus index.");
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                        scanner.nextLine();
                        break;
                    }
                    School selectedCampus = schools.get(campusIndex);
                    if (selectedCampus.getCourses().isEmpty()) {
                        System.out.println("No courses available in this campus for enrollment.");
                        break;
                    }
                    System.out.println("Select a course for enrollment from campus " + selectedCampus.getName() + ":");
                    for (int i = 0; i < selectedCampus.getCourses().size(); i++) {
                        System.out.println("[" + i + "] " + selectedCampus.getCourses().get(i).getName());
                    }
                    int courseIndex = -1;
                    try {
                        courseIndex = scanner.nextInt();
                        scanner.nextLine();
                        if (courseIndex < 0 || courseIndex >= selectedCampus.getCourses().size()) {
                            System.out.println("Invalid course index.");
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                        scanner.nextLine();
                        break;
                    }
                    Course selectedCourse = selectedCampus.getCourses().get(courseIndex);
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    int studentAge = 0;
                    while (true) {
                        System.out.print("Enter student age: ");
                        try {
                            studentAge = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Enter a valid number for age.");
                            scanner.nextLine();
                        }
                    }
                    int studentId = 0;
                    while (true) {
                        System.out.print("Enter student ID number: ");
                        try {
                            studentId = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Enter a valid number for ID.");
                            scanner.nextLine();
                        }
                    }
                    System.out.print("Enter student address: ");
                    String studentAddress = scanner.nextLine();
                    System.out.print("Enter semester type (off sem/regular sem): ");
                    String semester = scanner.nextLine();
                    Student enrolledStudent = new Student(studentName, studentAge, studentId, studentAddress, selectedCampus, selectedCourse, semester);
                    students.add(enrolledStudent);
                    System.out.println("Student officially enrolled!");
                    enrolledStudent.displayDetails();
                    break;

                case 5:
                    // Update an Item (update campus or enrolled student)
                    System.out.println("Update Options:");
                    System.out.println("1. Update Campus");
                    System.out.println("2. Update Enrolled Student");
                    System.out.print("Enter your choice: ");
                    int updateChoice = 0;
                    try {
                        updateChoice = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Returning to main menu.");
                        scanner.nextLine();
                        break;
                    }
                    if (updateChoice == 1) {
                        if (schools.isEmpty()) {
                            System.out.println("No campuses available to update.");
                        } else {
                            System.out.println("Select a campus to update:");
                            for (int i = 0; i < schools.size(); i++) {
                                System.out.println("[" + i + "] " + schools.get(i).getName());
                            }
                            int idx = scanner.nextInt();
                            scanner.nextLine();
                            if (idx >= 0 && idx < schools.size()) {
                                School campusToUpdate = schools.get(idx);
                                System.out.print("Enter new campus name: ");
                                String newCampusName = scanner.nextLine();
                                System.out.print("Enter new campus address: ");
                                String newCampusAddress = scanner.nextLine();
                                campusToUpdate.setName(newCampusName);
                                campusToUpdate.setAddress(newCampusAddress);
                                System.out.println("Campus updated successfully!");
                                campusToUpdate.displayDetails();
                            } else {
                                System.out.println("Invalid index.");
                            }
                        }
                    } else if (updateChoice == 2) {
                        if (students.isEmpty()) {
                            System.out.println("No enrolled students to update.");
                        } else {
                            System.out.println("Select a student to update:");
                            for (int i = 0; i < students.size(); i++) {
                                System.out.println("[" + i + "] " + students.get(i).getName());
                            }
                            int idx = scanner.nextInt();
                            scanner.nextLine();
                            if (idx >= 0 && idx < students.size()) {
                                Student studentToUpdate = students.get(idx);
                                System.out.print("Enter new student name: ");
                                String newStudentName = scanner.nextLine();
                                int newStudentAge = 0;
                                while (true) {
                                    System.out.print("Enter new student age: ");
                                    try {
                                        newStudentAge = scanner.nextInt();
                                        scanner.nextLine();
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Try again.");
                                        scanner.nextLine();
                                    }
                                }
                                int newStudentId = 0;
                                while (true) {
                                    System.out.print("Enter new student ID number: ");
                                    try {
                                        newStudentId = scanner.nextInt();
                                        scanner.nextLine();
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Try again.");
                                        scanner.nextLine();
                                    }
                                }
                                System.out.print("Enter new student address: ");
                                String newStudentAddress = scanner.nextLine();
                                System.out.print("Enter new semester type (off sem/regular sem): ");
                                String newSemester = scanner.nextLine();

                                // Optionally update campus
                                System.out.print("Do you want to update the enrolled campus? (yes/no): ");
                                String updateCampus = scanner.nextLine();
                                School newCampus = studentToUpdate.getCampus();
                                if (updateCampus.equalsIgnoreCase("yes")) {
                                    if (schools.isEmpty()) {
                                        System.out.println("No campuses available.");
                                    } else {
                                        System.out.println("Select a new campus:");
                                        for (int i = 0; i < schools.size(); i++) {
                                            System.out.println("[" + i + "] " + schools.get(i).getName());
                                        }
                                        int newCampusIndex = scanner.nextInt();
                                        scanner.nextLine();
                                        if (newCampusIndex >= 0 && newCampusIndex < schools.size()) {
                                            newCampus = schools.get(newCampusIndex);
                                        } else {
                                            System.out.println("Invalid campus index. Keeping previous campus.");
                                        }
                                    }
                                }

                                // Optionally update course from the new campus
                                System.out.print("Do you want to update the enrolled course? (yes/no): ");
                                String updateCourse = scanner.nextLine();
                                Course newCourse = studentToUpdate.getCourse();
                                if (updateCourse.equalsIgnoreCase("yes")) {
                                    if (newCampus.getCourses().isEmpty()) {
                                        System.out.println("No courses available in the selected campus.");
                                    } else {
                                        System.out.println("Select a new course from campus " + newCampus.getName() + ":");
                                        for (int i = 0; i < newCampus.getCourses().size(); i++) {
                                            System.out.println("[" + i + "] " + newCampus.getCourses().get(i).getName());
                                        }
                                        int newCourseIndex = scanner.nextInt();
                                        scanner.nextLine();
                                        if (newCourseIndex >= 0 && newCourseIndex < newCampus.getCourses().size()) {
                                            newCourse = newCampus.getCourses().get(newCourseIndex);
                                        } else {
                                            System.out.println("Invalid course index. Keeping previous course.");
                                        }
                                    }
                                }

                                studentToUpdate.setName(newStudentName);
                                studentToUpdate.setAge(newStudentAge);
                                studentToUpdate.setIdNo(newStudentId);
                                studentToUpdate.setAddress(newStudentAddress);
                                studentToUpdate.setSemester(newSemester);
                                studentToUpdate.setCampus(newCampus);
                                studentToUpdate.setCourse(newCourse);
                                System.out.println("Student updated successfully!");
                                studentToUpdate.displayDetails();
                            } else {
                                System.out.println("Invalid index.");
                            }
                        }
                    } else {
                        System.out.println("Invalid update option.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting the application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
