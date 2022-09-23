package weshare.persistence;

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.Update;

public interface CreateTables extends BaseQuery {

    @Update("CREATE TABLE IF NOT EXISTS library_users (" +
            "firstname varchar(25)  NOT NULL, " +
            "lastname varchar(25) NOT NULL, " +
            "email varchar(50) PRIMARY KEY NOT NULL, " +
            "password varchar(8) NOT NULL)")
    void createPersonTable();

    @Update("CREATE TABLE IF NOT EXISTS genres (" +
            "code varchar(25) PRIMARY KEY NOT NULL, " +
            "description varchar(50) NOT NULL)")
    void createGenreTable();

    @Update("CREATE TABLE IF NOT EXISTS books (" +
            "ISBN varchar(6) PRIMARY KEY NOT NULL, " +
            "title varchar(25) NOT NULL, " +
            "genre_code varchar(10) NOT NULL," +
            "edition varchar(8) NOT NULL, " +
            "FOREIGN KEY(genre_code) REFERENCES Genres(code))")
    void createBookTable();

    @Update("CREATE TABLE IF NOT EXISTS authors (" +
            "author_id varchar(25) PRIMARY KEY NOT NULL, " +
            "firstname varchar(25) NOT NULL, " +
            "lastname varchar(25) NOT NULL, " +
            "email varchar(50) NOT NULL)")
    void createAuthorsTable();

    @Update("CREATE TABLE IF NOT EXISTS book_author (" +
            "ISBN varchar(6) PRIMARY KEY NOT NULL, " +
            "author_id varchar(25) NOT NULL, " +
            "FOREIGN KEY(ISBN) REFERENCES books(ISBN), " +
            "FOREIGN KEY(author_id) REFERENCES authors(author_id))")
    void createBookAuthorTable();

    @Update("CREATE TABLE IF NOT EXISTS borrowed_books (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
            "ISBN varchar(6) UNIQUE NOT NULL, " +
            "code varchar(25) NOT NULL, " +
            "email varchar(50) NOT NULL," +
            "date_issued varchar(20) NOT NULL," +
            "due_date varchar(20) NOT NULL, " +
            "FOREIGN KEY(ISBN) REFERENCES books(ISBN), " +
            "FOREIGN KEY(code) REFERENCES genres(code), " +
            "FOREIGN KEY(email) REFERENCES library_users(email))")
    void createBorrowedBooksTable();
}
