package weshare.persistence.collectionbased;

/*
 ** DO NOT CHANGE!!
 */


import net.lemnik.eodsql.EoDException;
import net.lemnik.eodsql.QueryTool;
import weshare.model.Person;
import weshare.persistence.LibraryFinder_interface;
import weshare.persistence.LibraryUser_interface;
import weshare.persistence.PersonDAO;

import java.sql.Connection;
import java.util.*;

public class PersonDAOImpl implements PersonDAO {
    private final Set<Person> setOfPeople;

    public PersonDAOImpl() {
        setOfPeople = new HashSet<>();
        new DbConnection();
        users();
    }

    public PersonDAOImpl(Collection<Person> people) {
        setOfPeople = new HashSet<>(people);
        new DbConnection();
    }

    @Override
    public Optional<Person> findPersonByEmail(String email) {
        return setOfPeople.stream().filter(p -> p.getEmail().equals(email)).findFirst();
    }

    private LibraryUser_interface getUserInterface(){
        Connection connection = DbConnection.getConnection();
        LibraryUser_interface user_interface = QueryTool.getQuery(
                connection,
                LibraryUser_interface.class);
        return user_interface;
    }
    @Override
    public Person savePerson(Person person) {
        getUserInterface().savePerson(person.getFirstname(),
                person.getLastname(),
                person.getEmail(),
                person.getPassword());
        return person;
    }

    @Override
    public Set<Person> users() {
        try{
            getUserInterface().getUsers().forEach(
                    personDO -> setOfPeople.add(new Person(
                            personDO.getEmail(),
                            personDO.getFirstname(),
                            personDO.getLastname(),
                            personDO.getPassword())));
            return setOfPeople;
        }catch (EoDException e){
          return   Collections.<Person>emptySet();
        }
    }

    @Override
    public boolean login(String email, String password) {
        return setOfPeople.stream().anyMatch(p ->
                p.getEmail().equals(email) &&
                        p.getPassword().equals(password));
    }
}
