package weshare.persistence.wtc_library_db;

import net.lemnik.eodsql.ResultColumn;

public class BookAuthorDO {
    private String ISBN, author_id;

    public String getISBN() {
        return ISBN;
    }

    @ResultColumn(value = "ISBN")
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor_id() {
        return author_id;
    }

    @ResultColumn(value = "author_id")
    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }
}
