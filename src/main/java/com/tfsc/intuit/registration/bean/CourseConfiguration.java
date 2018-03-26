package com.tfsc.intuit.registration.bean;

import com.tfsc.intuit.registration.service.api.CourseService;
import com.tfsc.intuit.registration.service.impl.CourseServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sharanya.p on 3/24/2018.
 */
@Configuration
public class CourseConfiguration {

    @Bean
    public CourseService courseService() {
        return new CourseServiceImpl();
    }

}
