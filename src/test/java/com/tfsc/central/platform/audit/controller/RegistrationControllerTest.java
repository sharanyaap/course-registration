package com.tfsc.central.platform.audit.controller;

import com.tfsc.central.platform.audit.model.Application;
import com.tfsc.central.platform.audit.service.api.RegistrationService;
import com.tfsc.central.platform.audit.service.impl.RegistrationServiceImpl;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by harsh.sama on 6/16/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(RegistrationController.class)
public class RegistrationControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @TestConfiguration
    static class RegistrationServiceImplTestContextConfiguration {
        @Bean
        public RegistrationService registrationService() {
            return new RegistrationServiceImpl();
        }
    }

    @MockBean
    private RegistrationService registrationService;


    @Configuration
    @EnableAutoConfiguration
    public static class Config {
        @Bean
        public RegistrationController apiController() {
            return new RegistrationController();
        }
    }

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testregister_withAlreadyRegister() throws Exception {
        Application application = new Application("Assist", "e0269f97-0748-4a4d-9e7a-ea612d2073af");
        Mockito.when(registrationService.getApplication(Mockito.eq("Assist"))).thenReturn(application);
        mockMvc.perform(post("/registerApplication/application/Assist"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN_VALUE))
                .andExpect(jsonPath("$.message", is("Application is already registered")))

        ;
    }

    @Test
    public void testregister_withRegister() throws Exception {
        Application application = new Application("Assist", "e0269f97-0748-4a4d-9e7a-ea612d2073af");
        Mockito.when(registrationService.getApplication(Mockito.eq("Test"))).thenReturn(null);
        Mockito.when(registrationService.registerApplication(Mockito.eq("Test"))).thenReturn(application);

        mockMvc.perform(post("/registerApplication/application/Test"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN_VALUE))
                .andExpect(jsonPath("$.message", is("Application is registered successfully.")))

        ;
    }
}
