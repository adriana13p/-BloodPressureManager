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

        //convert user to dto
        BloodPressureDTO bloodPressureDTO = bloodPressureConverter.convertBloodPressureToDTO(bloodPressure, bloodPressure.getUser());
        return bloodPressureDTO;
    }

    public List<BloodPressureDTO> getBloodPressureListByUserId(long idUser) {
        //find a BloodPressure in the repository by idBloodPressure
        List<BloodPressure> usersBloodPressures = bloodPressureRepository.findByUserIdUserOrderByDateBPDesc(idUser);
        //convert usersBloodPressures to dto
        List<BloodPressureDTO> usersBloodPressuresDto = bloodPressureConverter.convertBloodPressureListToDto(usersBloodPressures);

        return usersBloodPressuresDto;
    }

    public List<BloodPressureDTO> getBloodPressureListByUserAndDate(long idUser, Date dateForBP) {
        //find a BloodPressure in the repository by idBloodPressure ans date
        List<BloodPressure> usersBloodPressures = bloodPressureRepository.findByUserIdUserAndDateBPOrderByDateBPDesc(idUser, dateForBP);
        //convert usersBloodPressures to dto
        List<BloodPressureDTO> usersBloodPressuresDto = bloodPressureConverter.convertBloodPressureListToDto(usersBloodPressures);

        return usersBloodPressuresDto;
    }

    public List<BloodPressureDTO> getBloodPressureListByUserAndDateBetween(long idUser, Date startDate, Date endDate) {
        //find a BloodPressure in the repository by idBloodPressure and date between
        // List<BloodPressure> usersBloodPressures = bloodPressureRepository.findByUserIdUserAndDateBPBetween(idUser, startDate, endDate);
        List<BloodPressure> usersBloodPressures = bloodPressureRepository.findByUserIdUserAndDateBPBetweenOrderByDateBPDesc(idUser, startDate, endDate);

      /*//order the list descending
      usersBloodPressures.sort(new Comparator<BloodPressure>() {
            @Override
            public int compare(BloodPressure o1, BloodPressure o2) {
                return -o1.getDateBP().compareTo(o2.getDateBP());
            }
        });*/

        //convert usersBloodPressures to dto
        List<BloodPressureDTO> usersBloodPressuresDto = bloodPressureConverter.convertBloodPressureListToDto(usersBloodPressures);

        return usersBloodPressuresDto;
    }

    @Transactional
    public boolean saveBloodPressure(BloodPressureDTO bloodPressureDto) {
        //save a BloodPressure in repository ()
       boolean savedBP = false;
        //check that at least one field is not empty
        if ((bloodPressureDto.getSystolicBP() == null) ||
                (bloodPressureDto.getDiastolicBP() == null) ||
                (bloodPressureDto.getNotesBP() == null) ||
                (bloodPressureDto.getDateBP() == null) ||
                (bloodPressureDto.getNotesBP() == null)) {
            //if sbp is null throw an exception
            throw new IllegalArgumentException("All fields can't be empty");
        }

        User user = userRepository.findOne(bloodPressureDto.getIdUser());
        BloodPressure bloodPressureObject = bloodPressureConverter.convertBloodPressureToObject(bloodPressureDto, user);
        //save blood pressure
        try {
            bloodPressureRepository.save(bloodPressureObject);
            savedBP = true;
        } catch (Exception e) {
            System.out.println("Error when saving bloodPressure " + e);
        }
        return savedBP;
    }

    public boolean deleteBloodPressureById(long bloodPressureId) {
        //delete a bloodPressure from repository
        //check bloodPressure ID
      boolean bpDeleted = false;
        boolean bloodPressureExists = checkBloodPressureIdExistInRepository(bloodPressureId);
        if (bloodPressureExists) {
            //if the bloodPressure id exists in repository, delete the user details
            try {
                bloodPressureRepository.delete(bloodPressureId);
                bpDeleted = true;
            } catch (Exception e) {
                System.out.print("Error when deleting bloodPressure " + e);
            }
        } else {
            System.out.println("Blood Pressure for id " + bloodPressureId + "does not exist");
        }
        return bpDeleted;
    }

    public BloodPressureDTO updateBloodPressure(long id, BloodPressureDTO bpDto) {
        //update a user by id
        BloodPressure bloodPressure = bloodPressureRepository.findOne(id);
        bloodPressure.setIdBP(bpDto.getIdBP());
        bloodPressure.setSystolicBP(bpDto.getSystolicBP());
        bloodPressure.setDiastolicBP(bpDto.getDiastolicBP());
        bloodPressure.setPulseBP(bpDto.getPulseBP());
        bloodPressure.setDateBP(bpDto.getDateBP());
        bloodPressure.setNotesBP(bpDto.getNotesBP());

        //getUser
        User user = userRepository.findOne(bpDto.getIdUser());
        //set user
        bloodPressure.setUser(user);

        BloodPressure savedObject = bloodPressureRepository.save(bloodPressure);
        return bloodPressureConverter.convertBloodPressureToDTO(savedObject, bloodPressure.getUser());
    }

    public boolean checkBloodPressureIdExistInRepository(long idBP) {
        //check if the bloodPressure id exists in repository
        boolean bloodPressureExists = false;
        //find a bloodPressure in the repository by userName
        BloodPressure bloodPressure = bloodPressureRepository.findOne(idBP);
        //check if the bloodPressure exists in repository
        if (bloodPressure == null) {
            //if the bloodPressure id exists in repository set the flag to true
            bloodPressureExists = false;
        } else {
            bloodPressureExists = true;
        }
        return bloodPressureExists;
    }
}
