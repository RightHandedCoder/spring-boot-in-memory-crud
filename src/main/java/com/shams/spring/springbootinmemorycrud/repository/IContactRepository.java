package com.shams.spring.springbootinmemorycrud.repository;

import com.shams.spring.springbootinmemorycrud.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IContactRepository extends CrudRepository<Contact, Long> {
}
