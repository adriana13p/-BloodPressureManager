package org.fasttrackit.bloodpressuremanager.service;

import org.fasttrackit.bloodpressuremanager.domain.BloodPressure;
import org.fasttrackit.bloodpressuremanager.domain.User;
import org.fasttrackit.bloodpressuremanager.dto.BloodPressureDTO;
import org.fasttrackit.bloodpressuremanager.exception.NotFoundException;
import org.fasttrackit.bloodpressuremanager.mapper.BloodPressureConverter;
import org.fasttrackit.bloodpressuremanager.persistence.BloodPressureRepository;
import org.fasttrackit.bloodpressuremanager.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Service for Blood Pressure
 */
@Service
public class BloodPressureService {

    @Autowired
    private BloodPressureRepository bloodPressureRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BloodPressureConverter bloodPressureConverter;


    public BloodPressureDTO getBloodPressureById(long idBloodPressure) {
        //find a BloodPressure in the repository by idBloodPressure
        BloodPressure bloodPressure = bloodPressureRepository.findOne(idBloodPressure);
        //check if the BloodPressure id exists in repository
        if (bloodPressure == null) {
            //if the id does not exist in repository, throw an exception
            throw new NotFoundException("" + idBloodPressure);
        }
        //getUser
        User user = userRepository.findOne(idBloodPressure);
        //convert user to dto
        BloodPressureDTO bloodPressureDTO = bloodPressureConverter.convertBloodPressureToDTO(bloodPressure, user);
        return bloodPressureDTO;
    }

    public List<BloodPressureDTO> getBloodPressureListByUserId(long idUser) {
        //find a BloodPressure in the repository by idBloodPressure
        List<BloodPressure> usersBloodPressures = bloodPressureRepository.findByUserIdUser(idUser);
        //convert usersBloodPressures to dto
        List<BloodPressureDTO> usersBloodPressuresDto = bloodPressureConverter.convertBloodPressureListToDto(usersBloodPressures);

        return usersBloodPressuresDto;
    }

    public List<BloodPressureDTO> getBloodPressureListByUserAndDate(long idUser, Date dateForBP) {
        //find a BloodPressure in the repository by idBloodPressure ans date
        List<BloodPressure> usersBloodPressures = bloodPressureRepository.findByUserIdUserAndDateBP(idUser, dateForBP);
        //convert usersBloodPressures to dto
        List<BloodPressureDTO> usersBloodPressuresDto = bloodPressureConverter.convertBloodPressureListToDto(usersBloodPressures);

        return usersBloodPressuresDto;
    }

    public List<BloodPressureDTO> getBloodPressureListByUserAndDateBetween(long idUser, Date startDate, Date endDate) {
        //find a BloodPressure in the repository by idBloodPressure and date between
        List<BloodPressure> usersBloodPressures = bloodPressureRepository.findByUserIdUserAndDateBPBetween(idUser, startDate, endDate);
        //convert usersBloodPressures to dto
        List<BloodPressureDTO> usersBloodPressuresDto = bloodPressureConverter.convertBloodPressureListToDto(usersBloodPressures);

        return usersBloodPressuresDto;
    }

    @Transactional
    public void saveBloodPressure(BloodPressureDTO bloodPressureDto) {
        //save a BloodPressure in repository ()
        //check user id is not null
        //  CheckUtils.checkLongElementIsNotNull(bloodPressureDto.getIdUserDto(), "User id");
        //check that at least one field is not empty
        if ((bloodPressureDto.getSystolicBPDto() == null) ||
                (bloodPressureDto.getDiastolicBPDto() == null) ||
                (bloodPressureDto.getNotesBPDto() == null) ||
                (bloodPressureDto.getDateBPDto() == null) ||
                (bloodPressureDto.getNotesBPDto() == null)) {
            //if sbp is null throw an exception
            throw new IllegalArgumentException("All fields can't be empty");
        }

        User user = userRepository.findOne(bloodPressureDto.getIdUserDto());
        BloodPressure bloodPressureObject = bloodPressureConverter.convertBloodPressureToObject(bloodPressureDto, user);
        //save blood pressure
        try {
            bloodPressureRepository.save(bloodPressureObject);
        } catch (Exception e) {
            System.out.println("Error when saving bloodPressure " + e);
        }
    }

    public void deleteBloodPressureById(long bloodPressureId) {
        //delete a bloodPressure from repository
        //check bloodPressure ID
        boolean bloodPressureExists = checkBloodPressureIdExistInRepository(bloodPressureId);
        if (bloodPressureExists == true) {
            //if the userDetails id exists in repository, delete the user details
            //get the bloodPressure object from repository
            BloodPressureDTO bloodPressureDTO = getBloodPressureById(bloodPressureId);
            //getUser
            User user = userRepository.findOne(bloodPressureId);
            //delete blood pressure
            //TODO intrebare: ar trebui sa pun cautarea de user " User user = userRepository.findOne(bloodPressureId)"
            // ininteriorul convertorului pt bloodPressure ?
            BloodPressure bloodPressureToDelete = bloodPressureConverter.convertBloodPressureToObject(bloodPressureDTO, user);
            try {
                bloodPressureRepository.delete(bloodPressureToDelete);
            } catch (Exception e) {
                System.out.print("Error when deleting bloodPressure " + e);
            }
        } else {
            System.out.println("Blood Pressure for id " + bloodPressureId + "does not exist");
        }
    }

    public BloodPressureDTO updateBloodPressure(long id, BloodPressureDTO bpDto) {
        //update a user by id
        BloodPressure bloodPressure = bloodPressureRepository.findOne(id);
        bloodPressure.setSystolicBP(bpDto.getSystolicBPDto());
        bloodPressure.setDiastolicBP(bpDto.getDiastolicBPDto());
        bloodPressure.setPulseBP(bpDto.getPulseBPDto());
        bloodPressure.setDateBP(bpDto.getDateBPDto());
        bloodPressure.setNotesBP(bpDto.getNotesBPDto());
        //TODO intrebare: daca vreau sa fac update la un bloodPressure trebuie sa-i setez toate filed-urile?
        //  sau doar cele care vreau sa le schimb?
        //  daca BloodPressure are si un field id si un obiect user trebuie sa leaici sau
        //  acelea vor ramane neschimbate?

        BloodPressure savedObject = bloodPressureRepository.save(bloodPressure);
        //get the user
        User user = userRepository.findOne(bpDto.getIdUserDto());
        return bloodPressureConverter.convertBloodPressureToDTO(savedObject, user);
    }

    public boolean checkBloodPressureIdExistInRepository(long idBP) {
        //heck if the bloodPressure id exists in repository
        boolean bloodPressureExists = false;
        //find a bloodPressure in the repository by userName
        BloodPressure bloodPressure = bloodPressureRepository.findOne(idBP);
        //check if the bloodPressure exists in repository
        if (bloodPressure == null) {
            //if the userDetails id exists in repository set the flag to true
            bloodPressureExists = false;
        } else {
            bloodPressureExists = true;
        }
        return bloodPressureExists;
    }
}
