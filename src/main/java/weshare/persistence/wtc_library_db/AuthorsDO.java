package weshare.persistence.wtc_library_db;

import net.lemnik.eodsql.ResultColumn;

public class AuthorsDO {
    private String firstname, lastname, author_id, email;

    public String getAuthor_id() {
        return author_id;
    }

    @ResultColumn(value = "author_id")
    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

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

    public String getEmail() {
        return email;
    }

    @ResultColumn(value = "email")
    public void setEmail(String email) {
        this.email = email;
    }
}
