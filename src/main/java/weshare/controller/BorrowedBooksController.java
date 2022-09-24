package weshare.controller;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import weshare.model.BorrowedBooks;
import weshare.model.Person;
import weshare.persistence.DataFinderDAO;
import weshare.persistence.DataRemoverDAO;
import weshare.server.Routes;
import weshare.server.ServiceRegistry;
import weshare.server.WeShareServer;

import java.util.List;
import java.util.Map;

public class BorrowedBooksController {

    private static int id;

    private static void setUuid(Context context) {
        BorrowedBooksController.id = Integer.parseInt((
                context.queryParams("bookID").get(0)));
    }

    public static final Handler view = context -> {
        DataFinderDAO finderDAO = ServiceRegistry.lookup(DataFinderDAO.class);
        Person personLoggedIn = WeShareServer.getPersonLoggedIn(context);

        finderDAO.reset();
        List<BorrowedBooks> books = finderDAO.findBorrowedBooks(
                personLoggedIn.getEmail());

        Map<String, Object> viewModel = Map.of("books", books);
        context.render("borrowed_books.html", viewModel);
    };

    public static final Handler readBook = context -> {
        DataFinderDAO finderDAO = ServiceRegistry.lookup(DataFinderDAO.class);
        Person personLoggedIn = WeShareServer.getPersonLoggedIn(context);

        setUuid(context);
        finderDAO.reset();
        List<BorrowedBooks> books = finderDAO.findBorrowedBooks(
                personLoggedIn.getEmail());


        Map<String, Object> viewModel = Map.of("book",
                books.stream().filter(borrowedBooks ->
        {return (borrowedBooks.getId() == id);}).findFirst().get());
        viewModel.forEach((s, o) -> System.out.println(o));

        context.render("read_book.html", viewModel);
    };

    public static final Handler returnBook = context -> {
        DataRemoverDAO dataRemoverDAO = ServiceRegistry.lookup(DataRemoverDAO.class);
        dataRemoverDAO.returnBorrowedBooks(id);
        context.redirect(Routes.HOME);
    };
}
