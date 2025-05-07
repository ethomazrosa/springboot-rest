package com.ethomaz.springboot_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ethomaz.springboot_rest.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
