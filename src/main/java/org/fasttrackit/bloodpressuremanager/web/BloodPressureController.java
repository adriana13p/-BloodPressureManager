package org.fasttrackit.bloodpressuremanager.web;

import org.fasttrackit.bloodpressuremanager.dto.BloodPressureDTO;
import org.fasttrackit.bloodpressuremanager.service.BloodPressureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class BloodPressureController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BloodPressureController.class);

    @Autowired
    private BloodPressureService bloodPressureService;


    @RequestMapping(path = "/bloodPressure/{id}", method = RequestMethod.GET)
    public BloodPressureDTO geBloodPressureById(@PathVariable("id") long id) {
        //get a bloodPressure by id
        return bloodPressureService.getBloodPressureById(id);
    }

    @RequestMapping(path = "/bloodPressureByDate/{idUser}/{dateForBP}", method = RequestMethod.GET)
    public List<BloodPressureDTO> getBloodPressureListByUserAndDate(@PathVariable("idUser") long idUser,
                                                                    @PathVariable("dateForBP") Date dateForBP) {
        //get a bloodPressure list  by user id and bloodPressure date
        return bloodPressureService.getBloodPressureListByUserAndDate(idUser, dateForBP);
    }

    @RequestMapping(path = "/bloodPressureByDateBetween/{idUser}/{startDate}/{endDate}",
            method = RequestMethod.GET)
    public List<BloodPressureDTO> getBloodPressureListByUserAndDateBetween(@PathVariable("idUser") long idUser,
                                                                           @PathVariable("startDate") Date startDate,
                                                                           @PathVariable("endDate") Date endDate) {
        //get a bloodPressure list  by user id and bloodPressure date between
        return bloodPressureService.getBloodPressureListByUserAndDateBetween(idUser, startDate, endDate);
    }


    @RequestMapping(path = "/saveBloodPressure", method = RequestMethod.POST)
    public void saveBloodPressure(@RequestBody BloodPressureDTO bloodPressureDTO) throws Exception {
        //save a bloodPressure
        bloodPressureService.saveBloodPressure(bloodPressureDTO);

    }

    @RequestMapping(path = "/updateBloodPressure/{id}", method = RequestMethod.PUT)
    public BloodPressureDTO updateBloodPressure(@PathVariable long id, @RequestBody BloodPressureDTO bloodPressureDTO) {
        //update a user
        return bloodPressureService.updateBloodPressure(id, bloodPressureDTO);
    }

    @RequestMapping(path = "/deleteBloodPressure/{id}", method = RequestMethod.DELETE)
    public void deleteBloodPressure(@PathVariable long id) throws Exception {
        //delete a bloodPressure
        bloodPressureService.deleteBloodPressureById(id);
    }
}
