package weshare.model;

public class BookAuthors {
    private final String  authur_id, ISBN;

    public BookAuthors(String authur_id, String isbn) {
        this.authur_id = authur_id;
        ISBN = isbn;
    }

    public String getAuthur_id() {
        return authur_id;
    }

    public String getISBN() {
        return ISBN;
    }
}
