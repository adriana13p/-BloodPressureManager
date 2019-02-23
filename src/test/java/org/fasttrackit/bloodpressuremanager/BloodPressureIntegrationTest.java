package org.fasttrackit.bloodpressuremanager;

import org.fasttrackit.bloodpressuremanager.domain.BloodPressure;
import org.fasttrackit.bloodpressuremanager.dto.BloodPressureDTO;
import org.fasttrackit.bloodpressuremanager.service.BloodPressureService;
import org.fasttrackit.bloodpressuremanager.util.DateUtils;
import org.fasttrackit.bloodpressuremanager.util.PrintUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Tests for blood pressures
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BloodPressureManagerApplication.class,
        loader = SpringApplicationContextLoader.class,
        initializers = ConfigFileApplicationContextInitializer.class)
public class BloodPressureIntegrationTest {

    @Autowired
    private BloodPressureService bloodPressureService;

    @Test
    public void testSaveBloodPressure() {
        //save a blood pressure with all fields filled
        BloodPressureDTO bloodPressureToSave = new BloodPressureDTO();
        bloodPressureToSave.setSystolicBPDto(118);
        bloodPressureToSave.setDiastolicBPDto(76);
        bloodPressureToSave.setPulseBPDto(73);
        bloodPressureToSave.setNotesBPDto("no medication");

        //format a string into date
        Date dateToSave = DateUtils.formatStringToDate("19.02.2019 13:15");
        //set the date
        bloodPressureToSave.setDateBPDto(dateToSave);
        bloodPressureToSave.setIdUserDto(2);
        bloodPressureService.saveBloodPressure(bloodPressureToSave);
    }

    @Test
    public void testFindBloodPressureById() {
        //find a blood pressure by  id
        BloodPressure bloodPressureOne = bloodPressureService.getBloodPressureById(13L);
        Assert.assertNotNull(bloodPressureOne);
        PrintUtils.printBloodPressureDto(bloodPressureOne);
    }

    @Test
    public void findUserBloodPressuresList() {
        //find a user's blood pressures list
        List<BloodPressureDTO> userBloodPressuresList = bloodPressureService.getBloodPressureListByUserId(2);
        //print the lis with blood pressures
        PrintUtils.printBloodPressureDtoList(userBloodPressuresList);

    }

    @Test
    public void findUserBloodPressuresByUserIdAndDate() {
        //format the date from String to Date
        Date dateToUse = DateUtils.formatStringToDate("19.02.2019 12:15:00");
        //find a user's blood pressures list
        List<BloodPressureDTO> userBloodPressuresList = bloodPressureService.getBloodPressureListByUserAndDate(2, dateToUse);
        //print the lis with blood pressures
        PrintUtils.printBloodPressureDtoList(userBloodPressuresList);
    }

    @Test
    public void findUserBloodPressuresByUserIdAndDateBetween() {
        //format a string into date
        Date startDateToUse = DateUtils.formatStringToDate("19.02.2019 00:00:00");
        Date endDateToUse = DateUtils.formatStringToDate("19.02.2019 23:59:59");
        //find a user's blood pressures list
        List<BloodPressureDTO> userBloodPressuresList = bloodPressureService.getBloodPressureListByUserAndDateBetween(2, startDateToUse, endDateToUse);
        //print the lis with blood pressures dto
        PrintUtils.printBloodPressureDtoList(userBloodPressuresList);
    }

    @Test
    public void deleteABloodPressure(){
        //delete a blood pressure by id
        bloodPressureService.deleteBloodPressureById(13);
        System.out.println("BloodPressure was deleted");
    }

}
