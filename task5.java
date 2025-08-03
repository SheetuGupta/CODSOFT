import java.io.*;
import java.util.*;

class Student {
    String name;
    String rollNumber;
    String grade;

    Student(String name, String rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String toString() {
        return rollNumber + "," + name + "," + grade;
    }

    public static Student fromString(String data) {
        String[] parts = data.split(",");
        if (parts.length == 3) {
            return new Student(parts[1], parts[0], parts[2]);
        }
        return null;
    }
}

class StudentManagementSystem {
    List<Student> students = new ArrayList<>();
    final String fileName = "students.txt";

    public StudentManagementSystem() {
        loadFromFile();
    }

    void addStudent(Student student) {
        students.add(student);
        saveToFile();
    }

    void removeStudent(String rollNumber) {
        students.removeIf(s -> s.rollNumber.equals(rollNumber));
        saveToFile();
    }

    void editStudent(String rollNumber, String newName, String newGrade) {
        for (Student s : students) {
            if (s.rollNumber.equals(rollNumber)) {
                s.name = newName;
                s.grade = newGrade;
                break;
            }
        }
        saveToFile();
    }

    Student searchStudent(String rollNumber) {
        for (Student s : students) {
            if (s.rollNumber.equals(rollNumber)) {
                return s;
            }
        }
        return null;
    }

    void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
            System.out.println("Roll No: " + s.rollNumber + ", Name: " + s.name + ", Grade: " + s.grade);
        }
    }

    void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Student s : students) {
                writer.write(s.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving to file.");
        }
    }

    void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Student s = Student.fromString(line);
                if (s != null) {
                    students.add(s);
                }
            }
        } catch (IOException e) {
            // File not exist yet
        }
    }
}

public class task5{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println(" Student Management System ");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = getIntInput(sc);

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter Roll Number: ");
                    String roll = sc.nextLine().trim();
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine().trim();
                    if (name.isEmpty() || roll.isEmpty() || grade.isEmpty()) {
                        System.out.println("All fields are required.");
                    } else {
                        sms.addStudent(new Student(name, roll, grade));
                        System.out.println("Student added.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Roll Number of Student to Edit: ");
                    String editRoll = sc.nextLine().trim();
                    Student studentToEdit = sms.searchStudent(editRoll);
                    if (studentToEdit != null) {
                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine().trim();
                        System.out.print("Enter New Grade: ");
                        String newGrade = sc.nextLine().trim();
                        if (newName.isEmpty() || newGrade.isEmpty()) {
                            System.out.println("Fields cannot be empty.");
                        } else {
                            sms.editStudent(editRoll, newName, newGrade);
                            System.out.println("Student updated.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll Number to Remove: ");
                    String removeRoll = sc.nextLine().trim();
                    sms.removeStudent(removeRoll);
                    System.out.println("Student removed.");
                    break;

                case 4:
                    System.out.print("Enter Roll Number to Search: ");
                    String searchRoll = sc.nextLine().trim();
                    Student found = sms.searchStudent(searchRoll);
                    if (found != null) {
                        System.out.println("Found: Name: " + found.name + ", Grade: " + found.grade);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    sms.displayAll();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    public static int getIntInput(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Enter a number: ");
            sc.next();
        }
        int num = sc.nextInt();
        sc.nextLine();
        return num;
    }
}
