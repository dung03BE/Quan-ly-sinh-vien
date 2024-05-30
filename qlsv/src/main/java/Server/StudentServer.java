/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import com.dungop.backend.presentation.StudentController;
import com.dungop.entity.Student;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dungi
 */
public class StudentServer {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started.");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket);

                // Handle client's request in a separate thread
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private StudentController studentController;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            this.studentController = new StudentController();
        }

        public void run() {
            try (
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ) {
        while (true) {
            // Nhận yêu cầu từ client
            String action = (String) ois.readObject();
            switch (action) {
                case "add":
                    // Nhận thông tin sinh viên từ client
                    Student studentToAdd = (Student) ois.readObject();
                    System.out.println("Received: " + studentToAdd);

                    // Thêm sinh viên vào cơ sở dữ liệu
                    boolean addResult = studentController.addStudent(studentToAdd.getMaSv(), studentToAdd.getName(), studentToAdd.getMajor(), studentToAdd.getLanguage(), studentToAdd.getScore());

                    // Trả về kết quả cho client
                    if (addResult) {
                        oos.writeObject("Student added successfully.");
                    } else {
                        oos.writeObject("Failed to add student.");
                    }
                    break;

                case "update":
                    // Nhận thông tin sinh viên cần cập nhật từ client
                    Student studentToUpdate = (Student) ois.readObject();
                    System.out.println("Received: " + studentToUpdate);

                    // Cập nhật thông tin sinh viên trong cơ sở dữ liệu
                    boolean updateResult = studentController.updateStudent(studentToUpdate.getMaSv(), studentToUpdate.getName(), studentToUpdate.getMajor(), studentToUpdate.getLanguage(), studentToUpdate.getScore());
                    // Trả về kết quả cho client
                    if (updateResult) {
                        oos.writeObject("Student updated successfully.");
                    } else {
                        oos.writeObject("Failed to update student.");
                    }
                    break;

                case "delete":
                    // Nhận mã sinh viên cần xóa từ client
                    String studentIDToDelete = (String) ois.readObject();
                    System.out.println("Received student ID to delete: " + studentIDToDelete);
                    // Xóa sinh viên khỏi cơ sở dữ liệu
                    boolean deleteResult = studentController.deleteStudent(studentIDToDelete);
                    // Trả về kết quả cho client
                    if (deleteResult) {
                        oos.writeObject("Student deleted successfully.");
                        oos.writeObject("delete_confirm");
                    } else {
                        oos.writeObject("Failed to delete student.");
                    }
                   
                    break;
                case "getStudentbyID":
                    // Nhận mã sinh viên cần xóa từ client
                    List<Student> ds = new ArrayList<>();
                    Student st = new Student();
                    String studentID = (String) ois.readObject();
                    System.out.println("Received student ID to getStudent: " + studentID);
                    ds = studentController.getStudentbyID(studentID);
                    // Trả về kết quả cho client
                    oos.writeObject(ds);
                    if (ds!=null) {
                        oos.writeObject("Get Student have id ="+studentID+"Thành công");
                        
                    } else {
                        oos.writeObject("Failed to Get student.");
                    }
                    break;
                default:
                    System.out.println("Invalid action.");
                    break;
            }
        }
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
        }
    }
}
