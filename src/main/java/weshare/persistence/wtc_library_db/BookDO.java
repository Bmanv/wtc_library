package weshare.persistence.wtc_library_db;

import net.lemnik.eodsql.ResultColumn;

public class BookDO {
    private String ISBN, title, genre_code, edition;

    public String getISBN() {
        return ISBN;
    }

    @ResultColumn(value = "ISBN")
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    @ResultColumn(value = "title")
    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre_code() {
        return genre_code;
    }

    @ResultColumn(value = "genre_code")
    public void setGenre_code(String genre_code) {
        this.genre_code = genre_code;
    }

    public String getEdition() {
        return edition;
    }

    @ResultColumn(value = "edition")
    public void setEdition(String edition) {
        this.edition = edition;
    }
}
