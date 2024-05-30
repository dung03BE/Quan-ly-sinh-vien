/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dungop.entity;

import java.io.Serializable;

/**
 *
 * @author dungi
 */
public class Student  implements Serializable {
    private String maSv;
    private String name;
    private String major;
    private String language;
    private float score;

    public Student() {
    }

    public Student(String maSv, String name, String major, String language, float score) {
        this.maSv = maSv;
        this.name = name;
        this.major = major;
        this.language = language;
        this.score = score;
    }

    public Student(String studentIDXoa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" + "maSv=" + maSv + ", name=" + name + ", major=" + major + ", language=" + language + ", score=" + score + '}';
    }
    
}
