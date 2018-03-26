package com.tfsc.central.platform.audit.repository;

import com.google.common.collect.ImmutableMap;
import com.tfsc.central.platform.audit.model.Audit;
import com.tfsc.central.platform.audit.repository.api.AuditRepository;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by sharanya.p on 6/20/2017.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuditRepositoryTest {

    @Autowired
    AuditRepository auditRepository;

    private static ObjectId id;

    @Test
    public void test1_save() {
        Map<String, Object> eventData = ImmutableMap.of("entityType", "com.tfsc.ilabs.ohs.model.Licence", "operationType", "updated");
        Audit audit = new Audit("testEntityId", eventData, "audit.test", null, "test@test.com", new Date(), new ObjectId(), "success", "127.0.0.1", null);
        audit = auditRepository.save(audit, "applicationAuditTest");
        Assert.assertTrue(null != audit);
    }

    @Test
    public void test2_findByEntityId() {
        List<Audit> audits = auditRepository.findByEntityId("testEntityId", "applicationAuditTest");
        Assert.assertTrue(audits.size() > 0);
        Assert.assertTrue("testEntityId".equals(audits.get(0).getEntityId()));
        id = audits.get(0).getId();
    }

    @Test
    public void test3_destroy() {
        auditRepository.remove(id.toString(), "applicationAuditTest");
    }

}
