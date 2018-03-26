package com.tfsc.intuit.registration.service.impl;

import com.tfsc.intuit.registration.dto.StudentCourseDto;
import com.tfsc.intuit.registration.model.StudentCourse;
import com.tfsc.intuit.registration.repository.StudentCourseRepository;
import com.tfsc.intuit.registration.service.api.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sharanya.p on 3/24/2018.
 */
@Transactional
public class StudentCourseServiceImpl implements StudentCourseService {

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Override
    public List<StudentCourse> getAll() {
        return studentCourseRepository.findAll();
    }

    @Override
    public StudentCourse add(StudentCourse studentCourse) {
        studentCourse.setStatus(0);
        return studentCourseRepository.save(studentCourse);
    }

    @Override
    public void update(StudentCourseDto studentCourseDto) {
        for (Integer studentCourseId :
                studentCourseDto.getStudentCourseIds()) {
            StudentCourse studentCourse = studentCourseRepository.findOne(studentCourseId);
            if (studentCourse != null) {
                studentCourse.setStatus(studentCourseDto.getStatus());
                studentCourseRepository.save(studentCourse);
            }
        }
        return;
    }

    @Override
    public List<StudentCourse> getAllStudentCourseByStudentId(Integer studentId) {
        return studentCourseRepository.findByStudentId(studentId);
    }
}
