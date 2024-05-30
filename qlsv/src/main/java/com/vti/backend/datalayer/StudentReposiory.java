/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vti.backend.datalayer;

import Resources.ConnectDB;
import com.vti.entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dungi
 */
public class StudentReposiory implements IStudentReposiory{

    @Override
    public boolean addStudent(String maSv, String name, String major, String language, float score) {
        boolean check = false;
        ConnectDB connectDB = new ConnectDB();
        Connection conn = connectDB.connect();
        String sql = "Insert into student(maSv,name,major,language,score) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maSv);
            ps.setString(2, name);
            ps.setString(3, major);
            ps.setString(4, language);
            ps.setFloat(5, score);
            int c = ps.executeUpdate();
            if(c>=0){
                check = true;
            }
            else
                check =false;
        } catch (SQLException ex) {
            System.out.println("Loi tai repository");
            Logger.getLogger(StudentReposiory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    @Override
    public boolean updateStudent(String maSv, String name, String major, String language, float score) {
       boolean check = false;
        ConnectDB connectDB = new ConnectDB();
        Connection conn = connectDB.connect();
        String sql = "UPDATE student SET name=?, major=?, language=?, Score=? WHERE masv=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
           
            ps.setString(1, name);
            ps.setString(2, major);
            ps.setString(3, language);
            ps.setFloat(4, score);
            ps.setString(5, maSv);
            int c = ps.executeUpdate();
            if(c>=0){
                check = true;
            }
            else
                check =false;
        } catch (SQLException ex) {
            System.out.println("Loi tai repository");
            Logger.getLogger(StudentReposiory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    @Override
    public boolean deleteStudent(String maSv) {
        boolean check = false;
        ConnectDB connectDB = new ConnectDB();
        Connection conn = connectDB.connect();
        String sql = "delete from student where masv=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maSv);
            int c = ps.executeUpdate();
            if(c>=0){
                check = true;
            }
            else
                check =false;
        } catch (SQLException ex) {
            System.out.println("Loi tai repository");
            Logger.getLogger(StudentReposiory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    @Override
    public List<Student> getStudentbyID(String masv) {
        List<Student> ds = new ArrayList<>();
        ConnectDB connectDB = new ConnectDB();
        Connection conn = connectDB.connect();
        String sql = "Select *from student where masv =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
     
                ps.setString(1,masv);
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
                    Student st = new Student();
                    st.setMaSv(masv);
                    st.setName(rs.getString("name"));
                    st.setMajor(rs.getString("major"));
                    st.setLanguage(rs.getString("language"));
                    st.setScore(rs.getFloat("score"));
                    ds.add(st);
                }
                for(Student s: ds)
                {
                    System.out.println(s.toString());
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentReposiory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }

   
}
