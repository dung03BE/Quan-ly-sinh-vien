/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vti.backend.businesslayer;

import com.vti.backend.datalayer.IStudentReposiory;
import com.vti.backend.datalayer.StudentReposiory;
import com.vti.entity.Student;
import java.util.List;

/**
 *
 * @author dungi
 */
public class StudentBusiness implements IStudentBusiness{
    private IStudentReposiory studentRepository;
    public StudentBusiness()
    {
        studentRepository = new StudentReposiory();
    }
    @Override
    public boolean addStudent(String maSv, String name, String major, String language, float score) {
        return studentRepository.addStudent(maSv, name, major, language, score);
    }

    @Override
    public boolean updateStudent(String maSv, String name, String major, String language, float score) {
      return  studentRepository.updateStudent(maSv, name, major, language, score);
    }

    @Override
    public boolean deleteStudent(String maSv) {
        return studentRepository.deleteStudent(maSv);
    }

    @Override
    public List<Student> getStudentbyID(String masv) {
        return studentRepository.getStudentbyID(masv);
    }
    
}
