package weshare.persistence;

import weshare.model.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DataFinderDAO {
    List<Book> allBooks();
    List<BorrowedBooks> findBorrowedBooks(String email);
    List<BookAuthors> findAllBookAuthors();
    Set<Genre> findAllGenres();
    List<Authors> findAllAuthors();

    Optional<Book> getBook(String ISBN);
    Optional<Genre> getGenre(String code);
    Optional<Authors> getAuthor(String author_id);
    Optional<BookAuthors> getBookAuthor(String ISBN,String author_id);
    void reset();




}
