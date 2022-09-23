package weshare.persistence.wtc_library_db;

import net.lemnik.eodsql.ResultColumn;

public class BorrowedBooksDO {
    private String ISBN, code, patron, date_issued, due_date;
    private int id;

    public String getISBN() {
        return ISBN;
    }

    @ResultColumn(value = "ISBN")
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getCode() {
        return code;
    }

    @ResultColumn(value = "code")
    public void setCode(String code) {
        this.code = code;
    }

    public String getPatron() {
        return patron;
    }

    @ResultColumn(value = "email")
    public void setPatron(String client) {
        this.patron = client;
    }

    public String getDate_issued() {
        return date_issued;
    }

    @ResultColumn(value = "date_issued")
    public void setDate_issued(String date_issued) {
        this.date_issued = date_issued;
    }

    public String getDue_date() {
        return due_date;
    }

    @ResultColumn(value = "due_date")
    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public int getId() {
        return id;
    }

    @ResultColumn(value = "id")
    public void setId(int id) {
        this.id = id;
    }
}
