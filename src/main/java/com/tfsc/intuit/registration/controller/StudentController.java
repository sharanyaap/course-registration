package com.tfsc.intuit.registration.controller;

import com.tfsc.intuit.registration.model.Student;
import com.tfsc.intuit.registration.service.api.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sharanya.p on 3/24/2018.
 */
@RestController
@RequestMapping("/students")
@Api(value = "students", description = "The APIs implemented herein deal with operations on Student(s)")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @CrossOrigin(origins = "http://localhost:8000")
    @ApiOperation(value = "Get all Students",
            nickname = "getAllStudents",
            httpMethod = "GET",
            response = Student.class,
            responseContainer = "List",
            notes = "This API shall return all available Student(s) in a List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Resource list successfully retrieved")
    })
    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @ApiOperation(value = "Create new Student",
            nickname = "addStudent",
            httpMethod = "POST",
            response = Student.class,
            notes = "This API shall enable users to create a new Student, given its parameters in a JSON")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Student creation successful", response = Student.class),
            @ApiResponse(code = 500, message = "Student creation failed. Internal error encountered")
    })
    @PostMapping
    public Student add(@RequestBody Student student) {
        return studentService.add(student);
    }


}
