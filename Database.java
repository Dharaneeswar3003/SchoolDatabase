import java.util.Scanner;

public class Database {
    public static void main(String[] args) {
        System.out.println("Welcome to the School Database");
        School school = new School("Lord Byng Secondary School", "Vancouver", 5);
        System.out.println("School details: \nSchool Name: " + school.getSchoolName() + "\nLocation: " + school.getSchoolLocation() + "\nNumber of Classes: " + school.getNumberOfClasses());
        System.out.println("-----------------------------------------------------------------------------------------------------");
        boolean continueLoop = true;
        Scanner scanner = new Scanner(System.in);

        while(continueLoop) {
            for (int i=0; i<3; i++) {
                System.out.println("Enter the details of teacher " + (i+1));
                System.out.print("First name of teacher " + (i+1) + " : ");
                String firstName = validateStringInput(scanner);
                System.out.print("Last name of teacher " + (i+1) + " : ");
                String lastName = validateStringInput(scanner);
                System.out.print("Subject that the teacher " + (i+1) + " teaches: ");
                System.err.print("Please enter one of the following subjects: English, French, Math, Science, Socials: ");
                String subject = validateSubjectInput(scanner);
                school.addTeacher(new Teacher(firstName, lastName, subject));
                System.out.println("-----------------------------------------------------------------------------------------------------");
            }
            for (int i=0; i<10; i++) {
                System.out.println("Enter the details of student " + (i+1));
                System.out.print("First name of student " + (i+1) + " : ");
                String firstName = validateStringInput(scanner);
                System.out.print("Last name of student " + (i+1) + " : ");
                String lastName = validateStringInput(scanner);
                System.out.print("Enter the grade of student " + (i+1) + " : ");
                int grade = validateGradeInput(scanner);
                school.addStudent(new Student(firstName, lastName, grade));
                System.out.println("-----------------------------------------------------------------------------------------------------");
            }
            System.out.println("Choose an option to continue: \n1. Display students and teachers  \n2. Remove students/teachers  \n3. Exit the program");
            int option = validateIntegerInput(scanner);
            switch(option) {
                case 1:
                    System.out.println("Students:");
                    school.showAllStudents();
                    System.out.println("Teachers:");
                    school.showAllTeachers();
                    System.out.println("Do you want to continue? (yes/no)");
                    String continueChoice = validateStringInput(scanner);
                    if (continueChoice.equalsIgnoreCase("no")) {
                        continueLoop = false;
                    }
                    break;
                case 2:
                    System.out.println("Choose an option to continue:\n1. Remove a student\n2. Remove a teacher\n3. Exit the program");
                    int choice = validateIntegerInput(scanner);
                    switch(choice) {
                        case 1:
                            System.out.println("Choose a student to remove. Enter the index number: ");
                            int studentIndex = validateIntegerInput(scanner);
                            if (studentIndex >= 1 && studentIndex <= 10) {
                                school.deleteStudent(school.getStudents().get(studentIndex - 1));
                            } else {
                                System.out.println("Invalid student index. Please enter a number between 1 and 10.");
                            }
                            break;
                        case 2:
                            System.out.println("Choose a teacher to remove. Enter the index number: ");
                            int teacherIndex = validateIntegerInput(scanner);
                            if (teacherIndex >= 1 && teacherIndex <= 10) {
                                school.deleteTeacher(school.getTeachers().get(teacherIndex - 1));
                            } else {
                                System.out.println("Invalid teacher index. Please enter a number between 1 and 10.");
                            }
                            break;
                        case 3:
                            System.out.println("Goodbye!");
                            continueLoop = false;
                            System.out.println("Final list of students and teachers:");
                            System.out.println("Students:");
                            school.showAllStudents();
                            System.out.println("Teachers:");
                            school.showAllTeachers();
                            scanner.close();
                            break;
                        default:
                            System.out.println("Invalid option. Please choose again.");
                    }
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    continueLoop = false;
                    System.out.println("Final list of students and teachers:");
                    System.out.println("Students:");
                    school.showAllStudents();
                    System.out.println("Teachers:");
                    school.showAllTeachers();
                    scanner.close();
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
        scanner.close();
    }

    private static String validateStringInput(Scanner scanner) {
        String input;
        while (true) {
            input = scanner.next();
            if (input.matches("[a-zA-Z]+")) {
                return input;
            } else {
                System.out.print("Invalid input. Please enter a valid string: ");
            }
        }
    }

    private static int validateGradeInput(Scanner scanner) {
        int input;
        while (true) {
            input = scanner.nextInt();
            if (input >= 8 && input <= 13) {
                return input;
            } else {
                System.out.print("Invalid input. Please enter a grade between 8 and 13: ");
            }
        }
    }

    private static int validateIntegerInput(Scanner scanner) {
        int input;
        while (true) {
            input = scanner.nextInt();
            return input;
        }
    }
    private static String validateSubjectInput(Scanner scanner) {
        String input;
        while (true) {
            input = scanner.next();
            if (input.equalsIgnoreCase("English") || input.equalsIgnoreCase("French") || input.equalsIgnoreCase("Math") || input.equalsIgnoreCase("Science") || input.equalsIgnoreCase("Socials")) {
                return input;
            } else {
                System.out.print("Invalid input/Subject not available. \nPlease enter one of the following subjects: English, French, Math, Science, Socials: ");
            }
        }
    }
}
