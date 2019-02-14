package com.tfsc.intuit.registration.repository;

import com.tfsc.intuit.registration.model.Course;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;

/**
 * Created by sharanya.p on 3/29/2018.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    private Integer courseId;

    @Before
    public void setUp() {
        Course course = new Course("testCourse", "desc", Timestamp.valueOf("2017-09-23 10:10:10.0"), Timestamp.valueOf("2017-11-23 10:10:10.0"), 20, true, "Lect1");
        course.setCourseId(100);
        course = courseRepository.save(course);
        courseId = course.getCourseId();
    }

    @Test
    public void testFindById() {
        Assert.assertTrue(courseId.equals(courseRepository.findOne(courseId).getCourseId()));
    }

    @After
    public void destroy() {
        courseRepository.delete(courseId);
    }
}
