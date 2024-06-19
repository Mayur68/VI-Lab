/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

/**
 *
 * @author mayur
 */
public class student {

    private String rollNo; // Changed from regNo
    private String name;
    private String course;
    private int sem;

    public student() {
        // Default constructor
    }

    public String getRollNo() {
        return rollNo; // Changed from regNo
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo; // Changed from regNo
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

}
