/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.dungop.frontend;

import Resources.ConnectDB;
import com.dungop.backend.presentation.StudentController;
import com.dungop.backend.utils.JdbcUtils;
import com.dungop.backend.utils.ScannerUtils;
import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author dungi
 */
public class TX1 {

    public static void main(String[] args) {
       menu();
       while(true)
       {
           int choice = ScannerUtils.inputInt();
           switch(choice)
           {
               case 1:
                   System.err.println("1. Thêm sinh viên");
                   addStudent();
                   break;
                case 2:
                   System.err.println("2. Sửa");
                   break;
                case 3:
                   System.err.println("3. Xóa");
                   break;
                case 4:
                   System.err.println("4. Tìm sinh viên theo id");
                   getSVbyID();
                   break;
                case 5:
                   System.err.println("Thoat");
                   System.exit(choice);
                   break;
                 default:
                     System.out.println("Đã thoát ct");
           }
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
    static void addStudent()
    {
        StudentController studentController = new StudentController();
        System.out.println("Nhap ma sv:");
        String masv = ScannerUtils.inputString();
        System.out.println("Nhap name:");
        String name = ScannerUtils.inputString();
        System.out.println("Nhap major:");
        String major = ScannerUtils.inputString();
        System.out.println("Language:");
        String language = ScannerUtils.inputString();
        System.out.println("Nhap score:");
        float score = ScannerUtils.inputFloat();
        studentController.addStudent(masv, name, major, language, score);
    }
    static void getSVbyID()
    {
        StudentController studentController = new StudentController();
        System.out.println("Nhap ma sv muon lay:");
        String masv = ScannerUtils.inputString();
        studentController.getStudentbyID(masv);
    }
}
