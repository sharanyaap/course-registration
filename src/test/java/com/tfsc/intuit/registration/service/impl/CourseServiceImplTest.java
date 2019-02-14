package com.tfsc.intuit.registration.service.impl;

import com.tfsc.intuit.registration.model.Course;
import com.tfsc.intuit.registration.repository.CourseRepository;
import com.tfsc.intuit.registration.service.api.CourseService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanya.p on 3/29/2018.
 */
@RunWith(SpringRunner.class)
public class CourseServiceImplTest {

    @TestConfiguration
    static class CourseServiceImplTestContextConfiguration {
        @Bean
        public CourseService courseService() {
            return new CourseServiceImpl();
        }
    }

    Course course;
    @MockBean
    private CourseRepository courseRepository;

    @Autowired
    private CourseService courseService;

    @Before
    public void setUp() throws Exception {
        course = new Course("testCourse", "desc", Timestamp.valueOf("2017-09-23 10:10:10.0"), Timestamp.valueOf("2017-11-23 10:10:10.0"), 20, true, "Lect1");
        List<Course> courses = new ArrayList() {{
            add(course);
        }};
        Mockito.when(courseRepository.findAll()).thenReturn(courses);

    }

    /*@Test
    public void testRegisterApplication() {
        Mockito.when(courseRepository.save(any(Course.class))).thenReturn(course);
        Assert.assertEquals(application, courseRepository.registerApplication("cob"));
    }*/

    @Test
    public void testGetApplication() {
        Assert.assertEquals(course, courseService.getAll().get(0));
    }
}
