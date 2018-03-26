package com.tfsc.central.platform.audit.service.impl;

import com.tfsc.central.platform.audit.model.Application;
import com.tfsc.central.platform.audit.repository.api.ApplicationRepository;
import com.tfsc.central.platform.audit.service.api.RegistrationService;
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

import static org.mockito.Matchers.any;

/**
 * Created by harsh.sama on 6/16/2017.
 */
@RunWith(SpringRunner.class)
public class RegistrationServiceImplTest {

    @TestConfiguration
    static class RegistrationServiceImplTestContextConfiguration {
        @Bean
        public RegistrationService registrationService() {
            return new RegistrationServiceImpl();
        }
    }

    Application application;
    @MockBean
    private ApplicationRepository applicationRepository;

    @Autowired
    private RegistrationService registrationService;

    @Before
    public void setUp() throws Exception {
        application = new Application("cob", "e0269f97-0748-4a4d-9e7a-ea612d2073af");
        Mockito.when(applicationRepository.findByApplicationName(application.getApplicationName())).thenReturn(application);

    }

    @Test
    public void testRegisterApplication() {
        Mockito.when(applicationRepository.save(any(Application.class))).thenReturn(application);
        Assert.assertEquals(application, registrationService.registerApplication("cob"));
    }

    @Test
    public void testGetApplication() {
        Assert.assertEquals(application, registrationService.getApplication("cob"));
    }

}
