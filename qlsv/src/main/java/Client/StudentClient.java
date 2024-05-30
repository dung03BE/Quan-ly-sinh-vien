/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import com.vti.entity.Student;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dungi
 */
public class StudentClient {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);
        ) {
            while (true) {
                 // Hiển thị menu chức năng cho người dùng
                menu();
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                switch(choice)
                {
                    case 1:         
                         // Input student information
                        oos.writeObject("add");
                        System.out.println("Enter student information:");
                        System.out.print("Student ID: ");
                        String studentID = scanner.nextLine();
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Major: ");
                        String major = scanner.nextLine();
                        System.out.print("Language: ");
                        String language = scanner.nextLine();
                        System.out.print("Score: ");
                        float score = scanner.nextFloat();
                        scanner.nextLine(); // Consume newline
                        // Create student object
                        Student student = new Student(studentID, name, major, language, score);
                        // Send student object to server
                        oos.writeObject(student);
                        // Receive response from server
                        String response = (String) ois.readObject();
                        System.out.println("Server response: " + response);
                        break;
                    case 2:
                        oos.writeObject("update");
                        System.out.println("Enter student you want to update:");
                        System.out.print("Student ID Cần sửa: ");
                        String studentIDCu = scanner.nextLine();
                        System.out.print("Name: ");
                        String nameNew = scanner.nextLine();
                        System.out.print("Major: ");
                        String majorNew = scanner.nextLine();
                        System.out.print("Language: ");
                        String languageNew = scanner.nextLine();
                        System.out.print("Score: ");
                        float scoreNew = scanner.nextFloat();
                        scanner.nextLine(); // Consume newline
                        // Create student object
                        Student studentNew = new Student(studentIDCu, nameNew, majorNew, languageNew, scoreNew);
                        // Send student object to server
                        oos.writeObject(studentNew);
                        // Receive response from server
                        String responseNew = (String) ois.readObject();
                        System.out.println("Server response: " + responseNew);
                        break;  
                    case 3:
                        oos.writeObject("delete");
                        System.out.println("Enter student you want to update:");
                        System.out.print("Student ID Cần Xoa: ");
                        String studentIDXoa = scanner.nextLine();
                       
                        oos.writeObject(studentIDXoa);
                        // Receive response from server
                        String responseXoa = (String) ois.readObject();
                        System.out.println("Server response: " + responseXoa);
                        
                        break;
                    case 4:
                        oos.writeObject("getStudentbyID");
                        System.out.println("Enter student you want to getStudent:");
                        System.out.print("Student ID: ");
                        String getId = scanner.nextLine();
                        oos.writeObject(getId);
                        List<Student> dsgetStudent = (List<Student>) ois.readObject();
                        for (Student getSt : dsgetStudent) {
                            System.out.println(getSt.toString());
                        }
                        // Receive response from server
                        String responseGetStudent = (String) ois.readObject();
                        System.out.println("Server response: " + responseGetStudent);
                        
                        break;
                     
                }       
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    static void menu()
    {
        System.out.println("CHUONG TRÌNH QLSV-2024 ");
        System.out.println("----------------------");
        System.err.println("1.Thêm sih vien");
        System.err.println("2.Sửa");
        System.err.println("3.Xóa");
        System.err.println("4.Tìm sinh viên theo mã");
        System.err.println("5.Thoát");
        System.out.println("Chọn chức năng:");
        
    }
}
