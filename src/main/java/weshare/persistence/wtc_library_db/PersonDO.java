package weshare.persistence.wtc_library_db;

import net.lemnik.eodsql.ResultColumn;

public class PersonDO {
    private String firstname, lastname, password, email;



    public String getFirstname() {
        return firstname;
    }

    @ResultColumn(value = "firstname")
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @ResultColumn(value = "lastname")
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    @ResultColumn(value = "password")
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    @ResultColumn(value = "email")
    public void setEmail(String email) {
        this.email = email;
    }
}
