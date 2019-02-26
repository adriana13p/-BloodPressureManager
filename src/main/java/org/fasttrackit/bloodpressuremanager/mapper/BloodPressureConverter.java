package org.fasttrackit.bloodpressuremanager.mapper;

import org.fasttrackit.bloodpressuremanager.domain.BloodPressure;
import org.fasttrackit.bloodpressuremanager.domain.User;
import org.fasttrackit.bloodpressuremanager.dto.BloodPressureDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Converters for blood pressure
 */
@Component
public class BloodPressureConverter {

    public BloodPressure convertBloodPressureToObject(BloodPressureDTO bloodPressureDTO, User userToSave) {
        //convert a bloodPressureDto to object ()

        BloodPressure bloodPressure = new BloodPressure();

        bloodPressure.setIdBP(bloodPressureDTO.getIdBP());
        bloodPressure.setSystolicBP(bloodPressureDTO.getSystolicBP());
        bloodPressure.setDiastolicBP(bloodPressureDTO.getDiastolicBP());
        bloodPressure.setPulseBP(bloodPressureDTO.getPulseBP());
        bloodPressure.setDateBP(bloodPressureDTO.getDateBP());
        bloodPressure.setNotesBP(bloodPressureDTO.getNotesBP());
        //set user id fk
        bloodPressure.setUser(userToSave);

        return bloodPressure;
    }

    public BloodPressureDTO convertBloodPressureToDTO(BloodPressure bloodPressure, User userToSave) {
        //convert a bloodPressure object to dto ()
        BloodPressureDTO bloodPressureDTO = new BloodPressureDTO();

        bloodPressureDTO.setIdBP(bloodPressure.getIdBP());
        bloodPressureDTO.setSystolicBP(bloodPressure.getSystolicBP());
        bloodPressureDTO.setDiastolicBP(bloodPressure.getDiastolicBP());
        bloodPressureDTO.setPulseBP(bloodPressure.getPulseBP());
        bloodPressureDTO.setDateBP(bloodPressure.getDateBP());
        bloodPressureDTO.setNotesBP(bloodPressure.getNotesBP());
        //set user id fk
        bloodPressureDTO.setIdUser(userToSave.getIdUser());

        return bloodPressureDTO;
    }


    public List<BloodPressureDTO> convertBloodPressureListToDto(List<BloodPressure> bloodPressuresList) {
        //convert a list of blood pressures from object to dto

        List<BloodPressureDTO> bloodPressuresListDto = new ArrayList<BloodPressureDTO>();

        for (int i = 0; i < bloodPressuresList.size(); i++) {
            BloodPressureDTO bloodPressureToAdd = new BloodPressureDTO();
            bloodPressureToAdd.setIdBP(bloodPressuresList.get(i).getIdBP());
            bloodPressureToAdd.setSystolicBP(bloodPressuresList.get(i).getSystolicBP());
            bloodPressureToAdd.setDiastolicBP(bloodPressuresList.get(i).getDiastolicBP());
            bloodPressureToAdd.setPulseBP(bloodPressuresList.get(i).getPulseBP());
            bloodPressureToAdd.setDateBP(bloodPressuresList.get(i).getDateBP());
            bloodPressureToAdd.setNotesBP(bloodPressuresList.get(i).getNotesBP());
            bloodPressureToAdd.setIdUser(bloodPressuresList.get(i).getUser().getIdUser());
            //add the object to the list
            bloodPressuresListDto.add(bloodPressureToAdd);
        }
        return bloodPressuresListDto;
    }
}
