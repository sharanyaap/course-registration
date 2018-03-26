package com.tfsc.intuit.registration.service.impl;

import com.tfsc.intuit.registration.model.Student;
import com.tfsc.intuit.registration.repository.StudentRepository;
import com.tfsc.intuit.registration.service.api.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sharanya.p on 3/24/2018.
 */
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student add(Student student) {
        return studentRepository.save(student);
    }


}
