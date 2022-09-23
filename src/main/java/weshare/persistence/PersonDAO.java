package weshare.persistence;

/*
 ** DO NOT CHANGE!!
 */


import weshare.model.Person;

import java.util.Optional;
import java.util.Set;

public interface PersonDAO {
    Optional<Person> findPersonByEmail(String email);
    Person savePerson(Person person);

    Set<Person> users();
    boolean login(String email, String password);

}
