import java.util.Scanner;

public class MainThread {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentController studentController =
                new StudentController(sc);

        while (true) {
            System.out.println("==================================================");
            System.out.println("        HE THONG QUAN LY SINH VIEN");
            System.out.println("==================================================");
            System.out.println("1. Them moi sinh vien");
            System.out.println("2. Hien thi danh sach sinh vien");
            System.out.println("3. Tim kiem sinh vien theo ten");
            System.out.println("4. Cap nhat diem GPA theo ma sinh vien");
            System.out.println("5. Xoa sinh vien theo ma sinh vien");
            System.out.println("6. Sap xep danh sach sinh vien theo GPA giam dan");
            System.out.println("7. Thoat chuong trinh");
            System.out.println("==================================================");
            System.out.print("Vui long chon chuc nang (1-7): ");

            int choice;

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
            } else {
                sc.nextLine();
                System.out.println("Invalid choice! Please enter a number.");
                System.out.println();
                continue;
            }

            switch (choice) {
                case 1:
                    studentController.addStudent();
                    break;

                case 2:
                    studentController.printStudentList();
                    break;

                case 3:
                    studentController.searchStudentByName();
                    break;

                case 4:
                    studentController.updateStudentGpa();
                    break;

                case 5:
                    studentController.deleteStudent();
                    break;

                case 6:
                    studentController.sortStudentsByGpaDescending();
                    break;

                case 7:
                    System.out.println("See you later!");
                    sc.close();
                    return;

                default:
                    System.out.println(
                        "Invalid choice! Please enter number from 1 to 7."
                    );
                    break;
            }

            System.out.println("Enter to continue!");
            sc.nextLine();
        }
    }
}