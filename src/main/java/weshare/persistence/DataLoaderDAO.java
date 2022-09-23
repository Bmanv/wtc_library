package weshare.persistence;

import weshare.model.Authors;
import weshare.model.Book;
import weshare.model.BorrowedBooks;
import weshare.model.Genre;

public interface DataLoaderDAO {
    Book saveBook(Book book);
    Genre saveGenre(Genre genre);
    Authors saveAuthors(Authors authors);
    BorrowedBooks saveBorrowedBooks(BorrowedBooks borrowedBooks,
                                    String email);
}
