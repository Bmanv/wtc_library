package weshare.model;

/*
 ** DO NOT CHANGE!!
 */


import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.apache.commons.validator.routines.EmailValidator;

public class Person {

    private final String email;
    private final String firstname,lastname,password;

    public Person(String email, String firstname, String lastname, String password) {

        if (!EmailValidator.getInstance().isValid(email)) throw new WeShareException("Bad email address");
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        String pseudonym = this.email.split("@")[0];
        return pseudonym.substring(0, 1).toUpperCase() + pseudonym.substring(1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equal(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("email", email)
                .toString();
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }
}
