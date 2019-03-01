package org.fasttrackit.bloodpressuremanager.web;

import org.fasttrackit.bloodpressuremanager.domain.User;
import org.fasttrackit.bloodpressuremanager.dto.BloodPressureDTO;
import org.fasttrackit.bloodpressuremanager.dto.BloodPressureWithUserNameDTO;
import org.fasttrackit.bloodpressuremanager.dto.UserDTO;
import org.fasttrackit.bloodpressuremanager.mapper.BloodPressureConverter;
import org.fasttrackit.bloodpressuremanager.persistence.UserRepository;
import org.fasttrackit.bloodpressuremanager.service.BloodPressureService;
import org.fasttrackit.bloodpressuremanager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class BloodPressureController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BloodPressureController.class);

    @Autowired
    private BloodPressureService bloodPressureService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BloodPressureConverter bloodPressureConverter;

    @RequestMapping(path = "/bloodPressureForUser/{userName}", method = RequestMethod.GET)
    public List<BloodPressureDTO> bloodPressureForUser(@PathVariable("userName") String userName) {
        //get user by name in order to obtain the users id
        UserDTO userDto = userService.getUserByUserName(userName);

        //get a bloodPressure by id
        return bloodPressureService.getBloodPressureListByUserId(userDto.getIdUser());
    }

    @RequestMapping(path = "/bloodPressureById/{idBP}", method = RequestMethod.GET)
    public BloodPressureDTO geBloodPressureById(@PathVariable("idBP") long idBP) {
        //get a bloodPressure by id
        return bloodPressureService.getBloodPressureById(idBP);
    }

    @RequestMapping(path = "/bloodPressureByUserId/{idUser}", method = RequestMethod.GET)
    public List<BloodPressureDTO> geBloodPressureByUserId(@PathVariable("idUser") long idUser) {
        //get a bloodPressure list by User id
        return bloodPressureService.getBloodPressureListByUserId(idUser);
    }

    @RequestMapping(path = "/bloodPressureByUserIdAndDate/{idUser}/{dateForBP}", method = RequestMethod.GET)
    public List<BloodPressureDTO> getBloodPressureListByUserAndDate(@PathVariable("idUser") long idUser,
                                                                    @PathVariable("dateForBP") Date dateForBP) {
        //get a bloodPressure list  by user id and bloodPressure date
        return bloodPressureService.getBloodPressureListByUserAndDate(idUser, dateForBP);
    }

    @RequestMapping(path = "/bloodPressureByUseIdAndDateBetween/{idUser}/{startDate}/{endDate}",
            method = RequestMethod.GET)
    public List<BloodPressureDTO> getBloodPressureListByUserAndDateBetween(@PathVariable("idUser") long idUser,
                                                                           @PathVariable("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                                                           @PathVariable("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        //get a bloodPressure list  by user id and bloodPressure date between
        return bloodPressureService.getBloodPressureListByUserAndDateBetween(idUser, startDate, endDate);
    }


    @RequestMapping(path = "/saveBloodPressure", method = RequestMethod.POST)
    public boolean saveBloodPressure(@RequestBody BloodPressureDTO bloodPressureDTO) throws Exception {
        //save a bloodPressure
        return bloodPressureService.saveBloodPressure(bloodPressureDTO);

    }
    @RequestMapping(path = "/saveBloodPressureForUserName", method = RequestMethod.POST)
    public boolean saveBloodPressureForUserName(@RequestBody BloodPressureWithUserNameDTO bloodPressureWithUserNameDTO) throws Exception {
      //save bloodPressure for user name
       User user = userRepository.findByUserName(bloodPressureWithUserNameDTO.getUserName());

        BloodPressureDTO bloodPressureDTO = bloodPressureConverter.convertBloodPressureWithNameToDTO(bloodPressureWithUserNameDTO,user);
        //save a bloodPressure
        return bloodPressureService.saveBloodPressure(bloodPressureDTO);

    }


    @RequestMapping(path = "/updateBloodPressure/{id}", method = RequestMethod.PUT)
    public BloodPressureDTO updateBloodPressure(@PathVariable long id, @RequestBody BloodPressureWithUserNameDTO bloodPressureWithUserNameDTO) {
        //save bloodPressure for user name
        User user = userRepository.findByUserName(bloodPressureWithUserNameDTO.getUserName());

        BloodPressureDTO bloodPressureDTO = bloodPressureConverter.convertBloodPressureWithNameToDTO(bloodPressureWithUserNameDTO,user);
        //update a bloodPressure
        return bloodPressureService.updateBloodPressure(id, bloodPressureDTO);
    }

    @RequestMapping(path = "/deleteBloodPressure/{id}", method = RequestMethod.DELETE)
    public boolean deleteBloodPressure(@PathVariable long id) throws Exception {
        //delete a bloodPressure
        return bloodPressureService.deleteBloodPressureById(id);
    }
}
