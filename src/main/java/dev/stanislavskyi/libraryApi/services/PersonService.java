package dev.stanislavskyi.libraryApi.services;

import dev.stanislavskyi.libraryApi.dto.v1.PersonDTO;
import dev.stanislavskyi.libraryApi.exception.PersonNotFoundException;
import dev.stanislavskyi.libraryApi.models.Person;
import dev.stanislavskyi.libraryApi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public Person findById(int id){
        Optional<Person> foundPerson = personRepository.findById(id);
        return foundPerson.orElseThrow(PersonNotFoundException::new);
    }

//    public Optional<Person> findByName(String name){
//        return personRepository.findByName(name);
//    }

    @Transactional
    public void save(Person person){
        personRepository.save(person);
    }

    @Transactional
    public void deleteById(int id){
        if (!personRepository.existsById(id)) {
            throw new PersonNotFoundException();
        }
        personRepository.deleteById(id);
    }

    @Transactional
    public void patch(Integer id, PersonDTO personDTO){
        Person personToUpdate = findById(id);

        if (personDTO.getName() != null) {
            personToUpdate.setName(personDTO.getName());
        }
    }

//    public Optional<Person> findByName(String name) {
//        return personRepository.findByName(name);
//    }

    @Transactional
    public void update(int id, Person person) {
        Person foundPerson = findById(id);
        foundPerson.setName(person.getName());
    }
}
