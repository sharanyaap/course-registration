package com.tfsc.intuit.registration.service.api;

import com.tfsc.intuit.registration.model.Course;

import java.util.List;

/**
 * Created by sharanya.p on 3/24/2018.
 */
public interface CourseService {

    List<Course> getAll();

    Course add(Course course);
}
