package org.fasttrackit.bloodpressuremanager.web;

import org.fasttrackit.bloodpressuremanager.dto.PersonDTO;
import org.fasttrackit.bloodpressuremanager.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);


    @Autowired
    private PersonService personService;


    @RequestMapping(path = "/person/{id}", method = RequestMethod.GET)
    public PersonDTO getPersonById(@PathVariable("id") long id) {
        //get a user by id
        return personService.getPersonById(id);
    }


    @RequestMapping(path = "/person", method = RequestMethod.POST)
    public void savePerson(@RequestBody PersonDTO person) {
        LOGGER.info("person >> {}", person.getPersonFirstNameDto() + " " + person.getPersonSecondNameDto());
        //save a person
        personService.savePerson(person);

    }

    @RequestMapping(path = "/person/{id}", method = RequestMethod.PUT)
    public PersonDTO updatePerson(@PathVariable long id, @RequestBody PersonDTO dto) {
        //update a person
        return personService.updatePerson(id, dto);

    }
}
