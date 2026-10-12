import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {
    private ArrayList<Student> studentList = new ArrayList<>();
    private Scanner sc;

    public StudentController(Scanner sc) {
        this.sc = sc;
    }

    // 1. Them sinh vien
    public void addStudent() {
        System.out.println("Create new student");

        String id;
        boolean exists;

        do {
            exists = false;

            System.out.print("Please enter student ID: ");
            id = sc.nextLine();

            if (id.trim().isEmpty()) {
                System.out.println("Student ID cannot be empty!");
                exists = true;
            } else {
                for (Student s : studentList) {
                    if (s.getId().equalsIgnoreCase(id)) {
                        System.out.println("Student ID already exists!");
                        exists = true;
                        break;
                    }
                }
            }
        } while (exists);

        System.out.print("Please enter full name: ");
        String fullName = sc.nextLine();

        System.out.print("Please enter email: ");
        String email = sc.nextLine();

        System.out.print("Please enter phone: ");
        String phone = sc.nextLine();

        double gpa;

        while (true) {
            System.out.print("Please enter GPA (0.0 - 4.0): ");

            if (sc.hasNextDouble()) {
                gpa = sc.nextDouble();
                sc.nextLine();

                if (gpa >= 0.0 && gpa <= 4.0) {
                    break;
                } else {
                    System.out.println("GPA must be from 0.0 to 4.0!");
                }
            } else {
                sc.nextLine();
                System.out.println("Invalid GPA! Please enter a number.");
            }
        }

        Student student = new Student();
        student.setId(id);
        student.setFullName(fullName);
        student.setEmail(email);
        student.setPhone(phone);
        student.setGpa(gpa);

        studentList.add(student);

        System.out.println("Add student successfully!");
    }

    // 2. Hien thi danh sach sinh vien
    public void printStudentList() {
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty!");
        } else {
            System.out.printf(
                "%-12s | %-25s | %-30s | %-15s | %s%n",
                "Student ID", "Full name", "Email", "Phone", "GPA"
            );

            for (Student s : studentList) {
                s.displayData();
            }
        }
    }

    // 3. Tim kiem sinh vien theo ten
    public void searchStudentByName() {
        System.out.print("Please enter student name: ");
        String name = sc.nextLine().toLowerCase();

        boolean found = false;

        for (Student s : studentList) {
            if (s.getFullName().toLowerCase().contains(name)) {
                s.displayData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }

    // 4. Cap nhat GPA theo ma sinh vien
    public void updateStudentGpa() {
        System.out.print("Please enter student ID: ");
        String id = sc.nextLine();

        boolean found = false;

        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                double gpa;

                while (true) {
                    System.out.print("Please enter new GPA (0.0 - 4.0): ");

                    if (sc.hasNextDouble()) {
                        gpa = sc.nextDouble();
                        sc.nextLine();

                        if (gpa >= 0.0 && gpa <= 4.0) {
                            break;
                        } else {
                            System.out.println(
                                "GPA must be from 0.0 to 4.0!"
                            );
                        }
                    } else {
                        sc.nextLine();
                        System.out.println(
                            "Invalid GPA! Please enter a number."
                        );
                    }
                }

                s.setGpa(gpa);
                System.out.println("Update GPA successfully!");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }

    // 5. Xoa sinh vien theo ma
    public void deleteStudent() {
        System.out.print("Please enter student ID: ");
        String id = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equalsIgnoreCase(id)) {
                studentList.remove(i);
                System.out.println("Delete student successfully!");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }

    // 6. Sap xep GPA giam dan
    public void sortStudentsByGpaDescending() {
        for (int i = 0; i < studentList.size() - 1; i++) {
            for (int j = i + 1; j < studentList.size(); j++) {
                if (studentList.get(i).getGpa()
                        < studentList.get(j).getGpa()) {

                    Student temp = studentList.get(i);

                    studentList.set(i, studentList.get(j));
                    studentList.set(j, temp);
                }
            }
        }

        System.out.println("Sort GPA descending successfully!");
        printStudentList();
    }
}