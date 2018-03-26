package com.tfsc.intuit.registration.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * Created by sharanya.p on 3/24/2018.
 */
@Entity(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(unique = true)
    private Integer studentId;

    @NotNull
    @Column(unique = true, updatable = false)
    private String studentName;

    @Column(nullable = true)
    private Timestamp dob;

    @Column
    private Integer semester;

    public Student() {
    }

    public Student(Integer studentId, String studentName, Timestamp dob, Integer semester) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.dob = dob;
        this.semester = semester;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Timestamp getDob() {
        return dob;
    }

    public void setDob(Timestamp dob) {
        this.dob = dob;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", dob=" + dob +
                ", semester=" + semester +
                '}';
    }
}
