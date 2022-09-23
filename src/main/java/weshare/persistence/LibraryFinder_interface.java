package weshare.persistence;

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Select;
import weshare.model.Authors;
import weshare.model.Genre;
import weshare.persistence.wtc_library_db.*;

import java.util.List;

public interface LibraryFinder_interface extends BaseQuery {

    //find all books
    @Select("SELECT * FROM books")
    List<BookDO> getBooks(); //select books with authors and genre (join tables)

    //find all borrowed books by user
    @Select("SELECT * FROM borrowed_books WHERE email = ?{1}")
    List<BorrowedBooksDO> getBorrowedBooks(String email); //select books with authors and genre (jo

    //find all genres
    @Select("SELECT * FROM genres, books WHERE books.genre_code=genres.code")
    List<GenreDO> getGenres();

    //find all authors
    @Select("SELECT * FROM authors")
    List<AuthorsDO> getAuthors();

    //find book_authors
    @Select("SELECT * FROM book_author")
    List<BookAuthorDO> getBookAuthors();

}
