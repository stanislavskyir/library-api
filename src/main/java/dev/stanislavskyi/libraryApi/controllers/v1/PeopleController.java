package dev.stanislavskyi.libraryApi.controllers.v1;

import dev.stanislavskyi.libraryApi.dto.v1.PersonDTO;
import dev.stanislavskyi.libraryApi.exception.PersonNotCreatedException;
import dev.stanislavskyi.libraryApi.mapper.PersonMapper;
import dev.stanislavskyi.libraryApi.models.Person;
import dev.stanislavskyi.libraryApi.services.PersonService;
import dev.stanislavskyi.libraryApi.utils.ErrorsUtil;
import dev.stanislavskyi.libraryApi.dto.v1.PeopleResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

import static dev.stanislavskyi.libraryApi.utils.UrlPath.*;

@RestController
@RequestMapping(API + V1 + PEOPLE)
public class PeopleController {

    private final PersonService personService;
    private final PersonMapper personMapper;

    @Autowired
    public PeopleController(PersonService personService, PersonMapper personMapper) {
        this.personService = personService;
        this.personMapper = personMapper;
    }

    //@PostMapping("/save")
    @PostMapping
    public ResponseEntity<HttpStatus> save(@RequestBody @Valid PersonDTO personDTO,
                                           BindingResult bindingResult) {

        validateCreatedPerson(bindingResult);

        Person person = personMapper.personDTOtoPerson(personDTO);

        personService.save(person);
        return ResponseEntity.ok(HttpStatus.CREATED);

    }

    @GetMapping
    public PeopleResponse findAll(){
        return new PeopleResponse(personService.findAll().stream().map(personMapper::personToPersonDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Integer id) {
        return personMapper.personToPersonDTO(personService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable Integer id,
                                             @RequestBody @Valid PersonDTO personDTO,
                                             BindingResult bindingResult) {

        validateCreatedPerson(bindingResult);

        Person person = personMapper.personDTOtoPerson(personDTO);
        personService.update(id, person);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> patch(@PathVariable Integer id,
                                            @RequestBody @Valid PersonDTO personDTO,
                                            BindingResult bindingResult) {

        validateCreatedPerson(bindingResult);

        personService.patch(id, personDTO);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
        personService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    private void validateCreatedPerson(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMsg = ErrorsUtil.returnErrorsToClient(bindingResult);
            throw new PersonNotCreatedException(errorMsg);
        }
    }

}
