package com.tfsc.intuit.registration.bean;

import com.tfsc.intuit.registration.service.api.StudentService;
import com.tfsc.intuit.registration.service.impl.StudentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sharanya.p on 3/24/2018.
 */
@Configuration
public class StudentConfiguration {

    @Bean
    public StudentService studentService() {
        return new StudentServiceImpl();
    }
}
