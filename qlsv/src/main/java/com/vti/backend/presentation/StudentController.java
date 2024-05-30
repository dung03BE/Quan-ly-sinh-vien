/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vti.backend.presentation;

import com.vti.backend.businesslayer.IStudentBusiness;
import com.vti.backend.businesslayer.StudentBusiness;
import com.vti.entity.Student;
import java.util.List;

/**
 *
 * @author dungi
 */
public class StudentController {
    private IStudentBusiness studentBusiness;
    public StudentController()
    {
        studentBusiness = new StudentBusiness();
    }
    public boolean addStudent(String maSv, String name, String major, String language, float score) {
        return studentBusiness.addStudent(maSv, name, major, language, score);
    }
    public boolean updateStudent(String maSv, String name, String major, String language, float score) {
        return studentBusiness.updateStudent(maSv, name, major, language, score);
    }
    public boolean deleteStudent(String maSv) {
        return studentBusiness.deleteStudent(maSv);
    }
    public List<Student> getStudentbyID(String masv) {
        return studentBusiness.getStudentbyID(masv);
    }
}
