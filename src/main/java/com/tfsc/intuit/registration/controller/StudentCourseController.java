package com.tfsc.intuit.registration.controller;

import com.tfsc.intuit.registration.dto.StudentCourseDto;
import com.tfsc.intuit.registration.model.StudentCourse;
import com.tfsc.intuit.registration.service.api.StudentCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sharanya.p on 3/24/2018.
 */
@RestController
@RequestMapping("/studentCourses")
@Api(value = "studentCourses", description = "The APIs implemented herein deal with operations on studentCourse(s)")
public class StudentCourseController {

    @Autowired
    private StudentCourseService studentCourseService;

    @CrossOrigin(origins = "http://localhost:8000")
    @ApiOperation(value = "Get all studentCourses",
            nickname = "getAllstudentCourses",
            httpMethod = "GET",
            response = StudentCourse.class,
            responseContainer = "List",
            notes = "This API shall return all available StudentCourse(s) in a List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Resource list successfully retrieved")
    })
    @GetMapping
    public List<StudentCourse> getAll() {
        return studentCourseService.getAll();
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @ApiOperation(value = "Create new StudentCourse",
            nickname = "addStudentCourse",
            httpMethod = "POST",
            response = StudentCourse.class,
            notes = "This API shall enable users to create a new StudentCourse, given its parameters in a JSON")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "StudentCourse creation successful", response = StudentCourse.class),
            @ApiResponse(code = 500, message = "StudentCourse creation failed. Internal error encountered")
    })
    @PostMapping
    public StudentCourse add(@RequestBody StudentCourse studentCourse) {
        return studentCourseService.add(studentCourse);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @ApiOperation(value = "Update a StudentCourse",
            nickname = "updateStudentCourse",
            httpMethod = "PUT",
            response = StudentCourseDto.class,
            notes = "This API shall enable users to update a StudentCourse, given its parameters in a JSON")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "StudentCourse update successful", response = StudentCourse.class),
            @ApiResponse(code = 500, message = "StudentCourse update failed. Internal error encountered")
    })
    @PutMapping("update")
    public boolean update(@RequestBody StudentCourseDto studentCourseDto) {
        try {
            studentCourseService.update(studentCourseDto);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @ApiOperation(value = "Get all studentCourses by student id",
            nickname = "getAllstudentCoursesbystudentId",
            httpMethod = "GET",
            response = StudentCourse.class,
            responseContainer = "List",
            notes = "This API shall return all available StudentCourse(s) in a List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Resource list successfully retrieved")
    })
    @GetMapping("/{studentId}")
    public List<StudentCourse> getAllStudentCourseByStudentId(@PathVariable Integer studentId) {
        return studentCourseService.getAllStudentCourseByStudentId(studentId);
    }

}
