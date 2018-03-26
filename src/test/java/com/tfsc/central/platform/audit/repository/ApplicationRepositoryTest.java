package com.tfsc.central.platform.audit.repository;

import com.tfsc.central.platform.audit.model.Application;
import com.tfsc.central.platform.audit.repository.api.ApplicationRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by sharanya.p on 6/15/2017.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationRepositoryTest {

    @Autowired
    ApplicationRepository applicationRepository;

    private String applicationId;

    @Before
    public void setUp() {
        Application application = new Application("testApp", "test123");
        application = applicationRepository.save(application);
        applicationId = application.getId();
    }

    @Test
    public void testFindByApplicationName() {
        Assert.assertTrue(applicationId.equals(applicationRepository.findByApplicationName("testApp").getId()));
    }

    @After
    public void destroy() {
        applicationRepository.delete(applicationId);
    }

}
