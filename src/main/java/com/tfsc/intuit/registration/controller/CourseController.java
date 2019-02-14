package com.tfsc.intuit.registration.controller;

import com.tfsc.intuit.registration.model.Course;
import com.tfsc.intuit.registration.service.api.CourseService;
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
@RequestMapping("/courses")
@Api(value = "courses", description = "The APIs implemented herein deal with operations on Course(s)")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @CrossOrigin(origins = "http://localhost:8000")
    @ApiOperation(value = "Get all Courses",
            nickname = "getAllCourses",
            httpMethod = "GET",
            response = Course.class,
            responseContainer = "List",
            notes = "This API shall return all available Course(s) in a List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Resource list successfully retrieved")
    })
    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @ApiOperation(value = "Create new Course",
            nickname = "addCourse",
            httpMethod = "POST",
            response = Course.class,
            notes = "This API shall enable users to create a new Course, given its parameters in a JSON")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Course creation successful", response = Course.class),
            @ApiResponse(code = 500, message = "Course creation failed. Internal error encountered")
    })
    @PostMapping
    public Course add(@RequestBody Course course) {
        return courseService.add(course);
    }

}
