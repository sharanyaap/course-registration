package com.tfsc.intuit.registration.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by sharanya.p on 3/24/2018.
 */
@Entity(name = "student_course")
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"student_id", "course_id"})
})
public class StudentCourse {

    @Id
    @GeneratedValue
    private Integer studentCourseId;

    @Column(name = "student_id")
    @NotNull
    private Integer studentId;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @Column(name = "course_id")
    @NotNull
    private Integer courseId;

    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    @NotNull
    @Column
    private Integer semester;

    @Column
    @NotNull
    private Integer status;

    public StudentCourse() {
    }

    public StudentCourse(Integer studentId, Student student, Integer courseId, Course course, Integer semester, Integer status) {
        this.studentId = studentId;
        this.student = student;
        this.courseId = courseId;
        this.course = course;
        this.semester = semester;
        this.status= status;
    }

    public Integer getStudentCourseId() {
        return studentCourseId;
    }

    public void setStudentCourseId(Integer studentCourseId) {
        this.studentCourseId = studentCourseId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "studentCourseId=" + studentCourseId +
                ", studentId=" + studentId +
                ", student=" + student +
                ", courseId=" + courseId +
                ", course=" + course +
                ", semester=" + semester +
                ", status=" + status +
                '}';
    }
}
