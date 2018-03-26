package com.tfsc.intuit.registration.service.impl;

import com.tfsc.intuit.registration.model.Course;
import com.tfsc.intuit.registration.repository.CourseRepository;
import com.tfsc.intuit.registration.service.api.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sharanya.p on 3/24/2018.
 */
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course add(Course course) {
        return courseRepository.save(course);
    }
}
