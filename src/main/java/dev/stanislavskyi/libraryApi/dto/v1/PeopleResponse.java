    package dev.stanislavskyi.libraryApi.dto.v1;

    import java.util.List;

    public class PeopleResponse {
        private List<PersonDTO> people;

        public PeopleResponse(List<PersonDTO> people) {
            this.people = people;
        }

        public List<PersonDTO> getPeople() {
            return people;
        }

        public void setPeople(List<PersonDTO> people) {
            this.people = people;
        }
    }
