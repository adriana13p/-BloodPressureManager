package org.fasttrackit.bloodpressuremanager;

import org.fasttrackit.bloodpressuremanager.domain.BloodPressure;
import org.fasttrackit.bloodpressuremanager.service.BloodPressureService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests for blood pressures
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BloodPressureManagerApplication.class, loader = SpringApplicationContextLoader.class, initializers = ConfigFileApplicationContextInitializer.class)
public class BloodPressureIntegrationTest {

    @Autowired
    private BloodPressureService bloodPressureService;

    @Test
    public void testSaveBloodPressure() {
        //save a blood pressure with all fields filled
        BloodPressure bloodPressure = new BloodPressure();
        bloodPressure.setSbp(125);
        bloodPressure.setDbp(65);
        bloodPressure.setPulse(73);
        bloodPressure.setDate("05.01.2019");
        bloodPressure.setHour(15);
        bloodPressure.setMinutes(32);

        //TODO : how to set the user id  if it is a foreign key !!!!!!
        //  bloodPressure.getBpUserId(1);
    }

    @Test
    public void testFindBloodPressure() {
        //find a blood pressure
        BloodPressure bloodPressureOne = bloodPressureService.findOneBloodPressure(1L);
        Assert.assertNotNull(bloodPressureOne);
    }


}
