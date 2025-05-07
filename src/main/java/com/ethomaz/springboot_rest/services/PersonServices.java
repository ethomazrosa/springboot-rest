package com.ethomaz.springboot_rest.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ethomaz.springboot_rest.exception.ResourceNotFoundException;
import com.ethomaz.springboot_rest.model.Person;
import com.ethomaz.springboot_rest.repository.PersonRepository;

@Service
public class PersonServices {

    // private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
        logger.info("Finding all people!");

        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding one person!");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
    }

    public Person create(Person person) {
        logger.info("Creating one person!");

        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating one person!");

        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        
        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");

        repository.deleteById(id);
    }

    // private Person mockPerson(int i) {
    //     logger.info("Finding one person!");

    //     Person person = new Person();
    //     person.setId(counter.incrementAndGet());
    //     person.setFirstName("FirstName " + i);
    //     person.setLastName("LastName " + i);
    //     person.setAddress("Address " + i);
    //     person.setGender("Male");

    //     return person;
    // }

}
