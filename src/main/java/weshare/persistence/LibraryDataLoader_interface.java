package weshare.persistence;

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Update;
import weshare.model.Book;

public interface LibraryDataLoader_interface extends BaseQuery {

    //insert book
    @Update("INSERT INTO books " +
            "(ISBN, title, genre_code," +
            " edition)" +
            " VALUES(?{1},?{2},?{3},?{4})")
    Book saveBook(String ISBN, String title,
                  String genre_code, String edition);

    //insert genre
    @Update("INSERT INTO genre " +
            "(code, description)" +
            " VALUES(?{1},?{2})")
    void saveGenre(String code, String description);

    //insert author
    @Update("INSERT INTO authors " +
            "(author_id, firstname, lastname," +
            " email)" +
            " VALUES(?{1},?{2},?{3},?{4})")
    void saveAuthor(String author_id, String firstname,
                    String lastname, String email);

    //insert book_author
    @Update("INSERT INTO book_author " +
            "(ISBN, author_id)" +
            " VALUES(?{1},?{2})")
    void saveBookAuthor(String code, String description);

    //insert borrowed_books
    @Update("INSERT INTO borrowed_books " +
            "(ISBN, code, email," +
            " date_issued, due_date)" +
            " VALUES(?{1},?{2},?{3},?{4},?{5})")
    void saveBorrowedBook(String ISBN, String code, String email,
                          String date_issued, String due_date);

}
