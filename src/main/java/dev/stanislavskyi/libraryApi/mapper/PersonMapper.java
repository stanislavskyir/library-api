package dev.stanislavskyi.libraryApi.mapper;

import dev.stanislavskyi.libraryApi.dto.v1.PersonDTO;
import dev.stanislavskyi.libraryApi.models.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
//@Mapper
public interface PersonMapper {

    @Mapping(target = "name", source = "entity.name")
    PersonDTO personToPersonDTO(Person entity);

    @Mapping(target = "name", source = "dto.name")
    Person personDTOtoPerson(PersonDTO dto);
}
