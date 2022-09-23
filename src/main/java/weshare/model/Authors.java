package weshare.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Authors {
    private final String firstname, lastname, author_id, email;


    public Authors(String firstname, String lastname,
                   String author_id, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.author_id = author_id;
        this.email = email;

    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authors authors = (Authors) o;
        return Objects.equal(author_id, authors.author_id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(author_id);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("firstname", firstname)
                .add("lastname", lastname)
                .add("author_id", author_id)
                .add("email", email)
                .toString();
    }
}
