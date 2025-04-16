package dev.stanislavskyi.libraryApi.services;

import dev.stanislavskyi.libraryApi.models.Person;
import dev.stanislavskyi.libraryApi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    @Transactional
    public void save(Person person){
        personRepository.save(person);
    }
}
