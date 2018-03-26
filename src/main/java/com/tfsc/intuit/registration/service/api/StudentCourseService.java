package com.tfsc.intuit.registration.service.api;

import com.tfsc.intuit.registration.dto.StudentCourseDto;
import com.tfsc.intuit.registration.model.StudentCourse;

import java.util.List;

/**
 * Created by sharanya.p on 3/24/2018.
 */
public interface StudentCourseService {

    List<StudentCourse> getAll();

    StudentCourse add(StudentCourse studentCourse);

    void update(StudentCourseDto studentCourseDto);

    List<StudentCourse> getAllStudentCourseByStudentId(Integer studentId);
}
