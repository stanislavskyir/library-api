package dev.stanislavskyi.libraryApi.controllers;

import dev.stanislavskyi.libraryApi.dto.PersonDTO;
import dev.stanislavskyi.libraryApi.models.Person;
import dev.stanislavskyi.libraryApi.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensors")
public class PeopleController {

    private final PersonService personService;

    @Autowired
    public PeopleController(PersonService personService) {
        this.personService = personService;
    }

    public ResponseEntity<HttpStatus> save(@RequestBody @Valid PersonDTO personDTO,
                                           BindingResult bindingResult) {

        //Sensor sensorToAdd = convertToSensor(sensorDTO);

        //sensorService.register(sensorToAdd);
        return ResponseEntity.ok(HttpStatus.OK);

    }

//    private Sensor convertToSensor(SensorDTO sensorDTO) {
//        return modelMapper.map(sensorDTO, Sensor.class);
//    }
}
