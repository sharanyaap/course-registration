package com.tfsc.intuit.registration.controller;

import com.tfsc.intuit.registration.model.Course;
import com.tfsc.intuit.registration.service.api.CourseService;
import com.tfsc.intuit.registration.service.impl.CourseServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by sharanya.p on 3/29/2018.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CourseController.class)
public class CourseControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @TestConfiguration
    static class CourseServiceImplTestContextConfiguration {
        @Bean
        public CourseService courseService() {
            return new CourseServiceImpl();
        }
    }


    @MockBean
    private CourseService courseService;


    @Configuration
    @EnableAutoConfiguration
    public static class Config {
        @Bean
        public CourseController apiController() {
            return new CourseController();
        }
    }

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testGetAll() throws Exception {
        Course course = new Course("testCourse", "desc", Timestamp.valueOf("2017-09-23 10:10:10.0"), Timestamp.valueOf("2017-11-23 10:10:10.0"), 20, true, "Lect1");
        List<Course> courses = new ArrayList() {{
            add(course);
        }};
        Mockito.when(courseService.getAll()).thenReturn(courses);
        mockMvc.perform(MockMvcRequestBuilders.get("/courses"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        //.andExpect(jsonPath("$.courseName", is("testCourse")))
        ;
    }

}
