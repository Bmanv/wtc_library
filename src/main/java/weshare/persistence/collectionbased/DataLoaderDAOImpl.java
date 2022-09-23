package weshare.persistence.collectionbased;

import net.lemnik.eodsql.QueryTool;
import weshare.model.*;
import weshare.persistence.DataLoaderDAO;
import weshare.persistence.LibraryDataLoader_interface;

import java.sql.Connection;

public class DataLoaderDAOImpl implements DataLoaderDAO {

    public DataLoaderDAOImpl() {
        new DbConnection();
    }

    private LibraryDataLoader_interface getDataInterface(){
        Connection connection = DbConnection.getConnection();
        LibraryDataLoader_interface loader_interface = QueryTool.getQuery(
                connection,
                LibraryDataLoader_interface.class);
        return loader_interface;
    }

    @Override
    public Book saveBook(Book book) {
        getDataInterface().saveBook(book.getISBN(),
                book.getTitle(),
                book.getGenre_code(),
                book.getEdition());
        return book;
    }

    @Override
    public Genre saveGenre(Genre genre) {

        getDataInterface().saveGenre(genre.getCode(), genre.getDescription());
        return genre;
    }

    @Override
    public Authors saveAuthors(Authors authors) {
        getDataInterface().saveAuthor(authors.getAuthor_id(),
                authors.getFirstname(),
                authors.getLastname(),
                authors.getEmail());
        return authors;
    }

    @Override
    public BorrowedBooks saveBorrowedBooks(BorrowedBooks borrowedBooks,
                                           String email) {
        getDataInterface().saveBorrowedBook(borrowedBooks.getBook().getISBN(),
                borrowedBooks.getBook().getGenre_code(),
                email,
                DateHelper.TODAY.toString(),
                DateHelper.TODAY.plusDays(7).toString());
        return borrowedBooks;
    }
}
