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

        bloodPressure.setIdBP(bloodPressureDTO.getIdBPDto());
        bloodPressure.setSystolicBP(bloodPressureDTO.getSystolicBPDto());
        bloodPressure.setDiastolicBP(bloodPressureDTO.getDiastolicBPDto());
        bloodPressure.setPulseBP(bloodPressureDTO.getPulseBPDto());
        bloodPressure.setDateBP(bloodPressureDTO.getDateBPDto());
        bloodPressure.setNotesBP(bloodPressureDTO.getNotesBPDto());
        //set user id fk
        bloodPressure.setUser(userToSave);

        return bloodPressure;
    }
    public BloodPressureDTO convertBloodPressureToDTO(BloodPressure bloodPressure, User userToSave) {
        //convert a bloodPressure object to dto ()
        BloodPressureDTO bloodPressureDTO = new BloodPressureDTO();

        bloodPressureDTO.setIdBPDto(bloodPressure.getIdBP());
        bloodPressureDTO.setSystolicBPDto(bloodPressure.getSystolicBP());
        bloodPressureDTO.setDiastolicBPDto(bloodPressure.getDiastolicBP());
        bloodPressureDTO.setPulseBPDto(bloodPressure.getPulseBP());
        bloodPressureDTO.setDateBPDto(bloodPressure.getDateBP());
        bloodPressureDTO.setNotesBPDto(bloodPressure.getNotesBP());
        //set user id fk
        bloodPressureDTO.setIdUserDto(userToSave.getIdUser());

        return bloodPressureDTO;
    }


    public List<BloodPressureDTO> convertBloodPressureListToDto(List<BloodPressure> bloodPressuresList) {
        //convert a list of blood pressures from object to dto

        List<BloodPressureDTO> bloodPressuresListDto = new ArrayList<BloodPressureDTO>();

        for (int i = 0; i < bloodPressuresList.size(); i++) {
            BloodPressureDTO bloodPressureToAdd = new BloodPressureDTO();
            bloodPressureToAdd.setIdBPDto(bloodPressuresList.get(i).getIdBP());
            bloodPressureToAdd.setSystolicBPDto(bloodPressuresList.get(i).getSystolicBP());
            bloodPressureToAdd.setDiastolicBPDto(bloodPressuresList.get(i).getDiastolicBP());
            bloodPressureToAdd.setPulseBPDto(bloodPressuresList.get(i).getPulseBP());
            bloodPressureToAdd.setDateBPDto(bloodPressuresList.get(i).getDateBP());
            bloodPressureToAdd.setNotesBPDto(bloodPressuresList.get(i).getNotesBP());
            bloodPressureToAdd.setIdUserDto(bloodPressuresList.get(i).getUser().getIdUser());
            //add the object to the list
            bloodPressuresListDto.add(bloodPressureToAdd);
        }
        return bloodPressuresListDto;
    }
}
