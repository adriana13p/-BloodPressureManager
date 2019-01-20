package org.fasttrackit.bloodpressuremanager;

import org.fasttrackit.bloodpressuremanager.domain.BloodPressure;
import org.fasttrackit.bloodpressuremanager.dto.BloodPressureDTO;
import org.fasttrackit.bloodpressuremanager.service.BloodPressureService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        BloodPressureDTO bloodPressureDTO = new BloodPressureDTO();
        bloodPressureDTO.setSystolicBPDto(125);
        bloodPressureDTO.setDiastolicBPDto(65);
        bloodPressureDTO.setPulseBPDto(73);

        //format a string into date
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String dateInString = "13.10.2018 12:10";
        try {
            Date date = formatter.parse(dateInString);
            bloodPressureDTO.setDateBPDto(date);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Date could not be converted");
        }


        //TODO : how to set the user id  !!!!!!

    }

    @Test
    public void testFindBloodPressure() {
        //find a blood pressure
        BloodPressure bloodPressureOne = bloodPressureService.findOneBloodPressure(1L);
        Assert.assertNotNull(bloodPressureOne);
    }


}
