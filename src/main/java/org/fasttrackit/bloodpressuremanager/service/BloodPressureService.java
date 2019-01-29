package org.fasttrackit.bloodpressuremanager.service;

import org.fasttrackit.bloodpressuremanager.domain.BloodPressure;
import org.fasttrackit.bloodpressuremanager.exception.NotFoundException;
import org.fasttrackit.bloodpressuremanager.persistence.BloodPressureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for Blood Pressure
 */
@Service
public class BloodPressureService {

    @Autowired
    private BloodPressureRepository bloodPressureRepository;


    public BloodPressure findOneBloodPressure(long idBloodPressure) {
        //find a BloodPressure in the repository by idBloodPressure
        BloodPressure bloodPressure = bloodPressureRepository.findOne(idBloodPressure);
        //check if the BloodPressure id exists in repository
        if (bloodPressure == null) {
            //if the id does not exist in repository, throw an exception
            throw new NotFoundException("" + idBloodPressure);
        }
        return bloodPressure;
    }


    public void saveBlodPressure(BloodPressure bloodPressure) {
        //save a BloodPressure in repository (doctorProstheticWork and patientName must not be null)
      /*  //check user id is not null
        if (bloodPressure.getBpUser() == null) {
            //if bpUserId is null throw an exception
            throw new IllegalArgumentException("User's id can not be null");
        }*/

        //check sbp and dbp
        if ((bloodPressure.getSystolicBP() == null) || (bloodPressure.getDiastolicBP() == null)) {
            //if sbp is null throw an exception
            throw new IllegalArgumentException("Systolic blood pressure and diastolic blood pressure values can NOT be null");
        }

        try {
            bloodPressureRepository.save(bloodPressure);
        } catch (Exception e) {
            System.out.print("Error when saving bloodPressure " + e);
        }
    }


}
