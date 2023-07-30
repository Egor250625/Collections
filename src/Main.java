import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {
   private static ArrayList<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Add student");
            System.out.println("2. Display all students");
            System.out.println("3. Find the oldest student");
            System.out.println("4. Calculate average age");
            System.out.println("5. Remove student by name");
            System.out.println("6. Remove student by age");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    findOldestStudent();
                    break;
                case 4:
                    calculateAverageAge();
                    break;
                case 5:
                    removeStudentByName(scanner);
                    break;
                case 6:
                    removeStudentByAge(scanner);
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 7);
    }
    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student's name: ");
        String name = scanner.next();
        System.out.print("Enter student's age: ");
        int age = scanner.nextInt();
        Student student = new Student(name, age);
        students.add(student);
        System.out.println("Student added successfully!");
    }
    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            System.out.println("List of students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
    private static void findOldestStudent() {
        if (students.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            Student oldestStudent = students.get(0);
            for (Student student : students) {
                if (student.getAge() > oldestStudent.getAge()) {
                    oldestStudent = student;
                }
            }
            System.out.println("Oldest student: " + oldestStudent);
        }
    }
    private static void calculateAverageAge() {
        if (students.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            int totalAge = 0;
            for (Student student : students) {
                totalAge += student.getAge();
            }
            double averageAge = (double) totalAge / students.size();
            System.out.println("Average age of students: " + averageAge);
        }
    }
    private static void removeStudentByName(Scanner scanner) {
        if (students.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            System.out.print("Enter the name of the student to remove: ");
            String name = scanner.next();
            boolean removed = false;
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                if (student.getName().equalsIgnoreCase(name)) {
                    students.remove(i);
                    removed = true;
                    System.out.println("Student removed successfully!");
                    break;
                }
            }
            if (!removed) {
                System.out.println("Student with the given name not found.");
            }
        }
    }
    private static void removeStudentByAge(Scanner scanner) {
        if (students.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            System.out.print("Enter the age of the student to remove: ");
            int age = scanner.nextInt();
            boolean removed = false;
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                if (student.getAge() == age) {
                    students.remove(i);
                    removed = true;
                    System.out.println("Student removed successfully!");
                    break;
                }
            }
            if (!removed) {
                System.out.println("Student with the given age not found.");
            }
        }
    }
}