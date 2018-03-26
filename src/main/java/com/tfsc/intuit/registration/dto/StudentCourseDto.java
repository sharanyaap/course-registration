package com.tfsc.intuit.registration.dto;

import java.util.List;

/**
 * Created by sharanya.p on 3/25/2018.
 */
public class StudentCourseDto {

    private List<Integer> studentCourseIds;

    private Integer status;

    public StudentCourseDto() {
    }

    public StudentCourseDto(List<Integer> studentCourseIds, Integer status) {
        this.studentCourseIds = studentCourseIds;
        this.status = status;
    }

    public List<Integer> getStudentCourseIds() {
        return studentCourseIds;
    }

    public void setStudentCourseIds(List<Integer> studentCourseIds) {
        this.studentCourseIds = studentCourseIds;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
