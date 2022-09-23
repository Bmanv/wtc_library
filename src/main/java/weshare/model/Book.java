package weshare.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Book {
    private  String ISBN, title, genre_code, edition;
    private  Genre genre;
    private  Authors authors;

    public Book(String isbn, String title, String genre_code, String edition) {
        ISBN = isbn;
        this.title = title;
        this.genre_code = genre_code;
        this.edition = edition;

    }
    public Book(String isbn, String title, String genre_code,
                String edition, Genre genre, Authors authors) {
        ISBN = isbn;
        this.title = title;
        this.genre_code = genre_code;
        this.edition = edition;
        this.genre = genre;
        this.authors = authors;

    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre_code() {
        return genre_code;
    }

    public String getEdition() {
        return edition;
    }

    public Genre getGenre() {
        return genre;
    }

    public Authors getAuthors() {
        return authors;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equal(ISBN, book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ISBN);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("ISBN", ISBN)
                .add("title", title)
                .add("genre_code", genre_code)
                .add("edition", edition)
                .add("genre" , genre)
                .add("author" , authors)
                .toString();
    }


}
