package weshare.persistence.collectionbased;

import net.lemnik.eodsql.EoDException;
import net.lemnik.eodsql.QueryTool;
import weshare.model.*;
import weshare.persistence.DataFinderDAO;
import weshare.persistence.LibraryDataRemover_interface;
import weshare.persistence.LibraryFinder_interface;
import weshare.persistence.wtc_library_db.BorrowedBooksDO;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.*;

public class DataFinderDAOImpl implements DataFinderDAO {
    private  List<Book> books;
    private List<BorrowedBooks> borrowedBooks;
    private Set<Genre> genres;
    private List<Authors> authors;
    private List<BookAuthors> bookAuthors;

    public DataFinderDAOImpl() {
        this.books = new ArrayList<>();
        this.borrowedBooks= new ArrayList<>();
        this.genres = new HashSet<>();
        this.authors = new ArrayList<>();
        this.bookAuthors = new ArrayList<>();
        new DbConnection();
        runTables();
    }

    private LibraryFinder_interface getFinderInterface(){
        Connection connection = DbConnection.getConnection();
        LibraryFinder_interface finder_interface = QueryTool.getQuery(
                connection,
                LibraryFinder_interface.class);
        return finder_interface;
    }


    private List<Book> readBooksFromdb(){
        try{
            getFinderInterface().getBooks().forEach(bookDO ->
                    books.add(new Book(bookDO.getISBN(),
                            bookDO.getTitle(),
                            bookDO.getGenre_code(),
                            bookDO.getEdition(),
                            getGenre(bookDO.getGenre_code()).get(),
                            null)));
            return books;
        }catch (EoDException e){
            return Collections.<Book>emptyList();
        }
    }


    private List<BookAuthors> readBookAuthors(){
        try{
            getFinderInterface().getBookAuthors().forEach(authorsDO ->
                    bookAuthors.add(new BookAuthors(authorsDO.getAuthor_id(),
                            authorsDO.getISBN()))
            );
            return bookAuthors;
        }catch (EoDException e){
            return Collections.<BookAuthors>emptyList();
        }
    }

    private Set<Genre> readGenres(){
        try{
            getFinderInterface().getGenres().forEach(genreDO ->
                    genres.add(new Genre(genreDO.getCode(),
                            genreDO.getDescription())));
            return genres;
        }catch (EoDException e){
            return Collections.<Genre>emptySet();
        }
    }

    private List<Authors> readAuthors(){
        try{
            getFinderInterface().getAuthors().forEach(authorsDO ->
                    authors.add(new Authors(authorsDO.getFirstname(),
                            authorsDO.getLastname(),
                            authorsDO.getAuthor_id(),
                            authorsDO.getEmail())));
            return authors;
        }catch (EoDException e){
            return Collections.<Authors>emptyList();
        }
    }

    @Override
    public List<Book> allBooks() {
        return books;
    }

    @Override
    public List<BorrowedBooks> findBorrowedBooks(String email) {

        try{
            System.out.println("We go");
            List<BorrowedBooksDO> borrowedBooks1 =
                    getFinderInterface().getBorrowedBooks(email);

            Connection connection= DbConnection.getConnection();
            LibraryDataRemover_interface dataRemover_interface=
                    QueryTool.getQuery(connection,
                            LibraryDataRemover_interface.class);
            for (var book :
                    borrowedBooks1) {

                if (checkDate(formatDate(book.getDue_date()))){
                    borrowedBooks1.remove(book.getId());
                    dataRemover_interface.delete(book.getId());
                }
            }

            if (!borrowedBooks1.isEmpty()) {
                borrowedBooks1.forEach(borrowedBooksDO ->
                        borrowedBooks.add(new BorrowedBooks(formatDate(
                                borrowedBooksDO.getDate_issued()).toString(),
                                formatDate(borrowedBooksDO.getDue_date()).toString(),
                                getBook(borrowedBooksDO.getISBN()).get(),
                                borrowedBooksDO.getId())));
                return borrowedBooks;
            }

            return Collections.<BorrowedBooks>emptyList();
        }catch (EoDException e){
            return Collections.<BorrowedBooks>emptyList();
        }
    }

    private LocalDate formatDate(String date){
        String[] date_temp = date.split("-");
        return LocalDate.parse((date_temp[2]+"/"+
                date_temp[1]+"/"+date_temp[0]),
                DateHelper.DD_MM_YYYY);
    }

    private boolean checkDate(LocalDate date) {

        return  (LocalDate.now().isAfter(date)) ;
    }
    @Override
    public List<BookAuthors> findAllBookAuthors() {
       return bookAuthors;
    }

    @Override
    public Set<Genre> findAllGenres() {
         return genres;
    }

    @Override
    public List<Authors> findAllAuthors() {
        return authors;
    }

    @Override
    public Optional<Book> getBook(String ISBN) {
        return books.stream().filter(book -> {
            return book.getISBN().equals(ISBN);
        }).findFirst();
    }

    @Override
    public Optional<Genre> getGenre(String code) {
        return genres.stream().filter(genre -> {
            return genre.getCode().equals(code);
        }).findFirst();
    }

    @Override
    public Optional<Authors> getAuthor(String author_id) {
        return authors.stream().filter(authors1 -> {
            return authors1.getAuthor_id().equals(author_id);
        }).findFirst();
    }

    @Override
    public Optional<BookAuthors> getBookAuthor(String ISBN, String author_id) {
        return bookAuthors.stream().filter(bookAuthors1 -> {
            return bookAuthors1.getISBN().equals(ISBN) &&
                bookAuthors1.getAuthur_id().equals(author_id);
        }).findFirst();
    }

    @Override
    public void reset() {
        borrowedBooks.clear();
    }


    private void runTables(){
        readGenres();
        readBookAuthors();
        readAuthors();
        readBooksFromdb();
    }

}
