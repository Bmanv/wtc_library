package weshare.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.time.LocalDate;

import static weshare.model.DateHelper.TODAY;

public class BorrowedBooks {
    private String date_issued, due_date;
    private Book book;
    private int id;

    public BorrowedBooks(String date_issued,
                         String due_date, Book book, int id) {
        this.date_issued = date_issued;
        this.due_date = due_date;
        this.book = book;
        this.id = id;
    }

    public BorrowedBooks() {
    }


    public String getDate_issued() {
        return date_issued;
    }

    public String getDue_date() {
        return due_date;
    }

    public Book getBook() {
        return book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowedBooks book = (BorrowedBooks) o;
        return Objects.equal(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("issued_date", date_issued)
                .add("due_date", due_date)
                .add("book", book)
                .toString();
    }

    public int daysLeftToReturnBook() {
        return TODAY.until(formatDate(this.due_date)).getDays();
    }

    private LocalDate formatDate(String date){
        String[] date_temp = date.split("-");
        return LocalDate.parse((date_temp[2]+"/"+
                date_temp[1]+"/"+date_temp[0]), DateHelper.DD_MM_YYYY);
    }
    public int getId() {
        return id;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
