/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dungop.backend.datalayer;

import com.dungop.entity.Student;
import java.util.List;

/**
 *
 * @author dungi
 */
public interface IStudentReposiory {
    public boolean addStudent(String maSv, String name, String major , String language, float score);
    public boolean updateStudent (String maSv,String name, String major, String language, float score);
    public boolean deleteStudent (String maSv);
    public List<Student> getStudentbyID(String masv);
}
