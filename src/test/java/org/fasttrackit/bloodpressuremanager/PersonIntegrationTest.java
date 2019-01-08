package org.fasttrackit.bloodpressuremanager;

import org.fasttrackit.bloodpressuremanager.domain.Person;
import org.fasttrackit.bloodpressuremanager.service.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests for persons
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BloodPressureManagerApplication.class, loader = SpringApplicationContextLoader.class, initializers = ConfigFileApplicationContextInitializer.class)
public class PersonIntegrationTest {

    @Autowired
    private PersonService personService;


   /* @Test
    public void testSavePerson() {
        //save a person with all fields filled
        Person person = new Person();
        person.setPersonFirstName("Precup");
        person.setPersonSecondName("Adriana");
        person.setAge(33);
        person.setGender('F');
        person.setNotes("no medication");
        personService.savePerson(person);
    }*/

    @Test
    public void testFindPerson() {
        //find a person
        Person personOne = personService.findOnePerson(1L);
        Assert.assertNotNull(personOne);
    }
}
