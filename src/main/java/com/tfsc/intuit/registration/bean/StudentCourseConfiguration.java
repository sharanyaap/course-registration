package com.tfsc.intuit.registration.bean;

import com.tfsc.intuit.registration.service.api.StudentCourseService;
import com.tfsc.intuit.registration.service.impl.StudentCourseServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sharanya.p on 3/24/2018.
 */
@Configuration
public class StudentCourseConfiguration {

    @Bean
    public StudentCourseService studentCourseService() {
        return new StudentCourseServiceImpl();
    }
}
