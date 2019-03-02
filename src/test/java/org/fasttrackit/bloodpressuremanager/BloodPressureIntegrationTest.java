package org.fasttrackit.bloodpressuremanager;

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
        bloodPressureToSave.setIdUser(4);
        bloodPressureToSave.setSystolicBP(118);
        bloodPressureToSave.setDiastolicBP(76);
        bloodPressureToSave.setPulseBP(73);
        bloodPressureToSave.setNotesBP("no medication");

        //format a string into date
        Date dateToSave = DateUtils.formatStringToDate("20.02.2019 11:15");
        //set the date
        bloodPressureToSave.setDateBP(dateToSave);
        bloodPressureService.saveBloodPressure(bloodPressureToSave);
    }

    @Test
    public void testFindBloodPressureById() {
        //find a blood pressure by  id
        BloodPressureDTO bloodPressureOne = bloodPressureService.getBloodPressureById(13L);
        Assert.assertNotNull(bloodPressureOne);
        PrintUtils.printBloodPressureDto(bloodPressureOne);
    }

    @Test
    public void findUserBloodPressuresList() {
        //find a user's blood pressures list
        List<BloodPressureDTO> userBloodPressuresList = bloodPressureService.getBloodPressureListByUserId(2);

        //print the list with blood pressures
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
    public void updateABloodPressure() {
        //update a blood pressure by id
        BloodPressureDTO bpToSet = new BloodPressureDTO();
        bpToSet.setIdBP(19);
        bpToSet.setIdUser(5);
        //format a string into date
        Date dateToSave = DateUtils.formatStringToDate("19.02.2019 09:35:59");
        bpToSet.setDateBP(dateToSave);
        bpToSet.setSystolicBP(153);
        bpToSet.setDiastolicBP(91);
        bpToSet.setPulseBP(89);
        bpToSet.setNotesBP("test");

        bloodPressureService.updateBloodPressure(12, bpToSet);
        System.out.println("BloodPressure was updated");
    }


    @Test
    public void deleteABloodPressure() {
        //delete a blood pressure by id
        bloodPressureService.deleteBloodPressureById(17);
        System.out.println("BloodPressure was deleted");
    }

}
