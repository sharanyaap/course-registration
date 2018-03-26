package com.tfsc.intuit.registration.service.api;

import com.tfsc.intuit.registration.model.Student;

import java.util.List;

/**
 * Created by sharanya.p on 3/24/2018.
 */
public interface StudentService {

    List<Student> getAll();

    Student add(Student student);

}
