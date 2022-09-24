package weshare.controller;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import weshare.model.*;
import weshare.persistence.*;
import weshare.server.Routes;
import weshare.server.ServiceRegistry;
import weshare.server.WeShareServer;

import java.util.Collection;
import java.util.Map;

public class ViewBookController {
    private static String ISBN;
    private static void setUuid(Context context) {
        ViewBookController.ISBN = (context.queryParams("bookID").get(0));

    }
    public static final Handler view = context -> {
        DataFinderDAO finderDAO = ServiceRegistry.lookup(DataFinderDAO.class);
        Person personLoggedIn = WeShareServer.getPersonLoggedIn(context);

        Collection<Book> books = finderDAO.allBooks();
        Map<String, Object> viewModel = Map.of("books", books);

        context.render("allbooks.html", viewModel);
    };

    public static final Handler viewBook = context -> {
        DataFinderDAO finderDAO = ServiceRegistry.lookup(DataFinderDAO.class);

        setUuid(context);
        Map<String, Object> viewModel = Map.of("book",
                finderDAO.getBook(ISBN).get());
        context.render("book_details.html", viewModel);
    };

    public static final Handler borrowBook = context -> {
        DataLoaderDAO loaderDAO = ServiceRegistry.lookup(DataLoaderDAO.class);
        Person personLoggedIn = WeShareServer.getPersonLoggedIn(context);
        DataFinderDAO finderDAO = ServiceRegistry.lookup(DataFinderDAO.class);

        Book book=finderDAO.getBook(ISBN).get();
        BorrowedBooks borrowedBooks=new BorrowedBooks(DateHelper.TODAY.toString(),
                DateHelper.TODAY.plusDays(7).toString(), book,0);

        loaderDAO.saveBorrowedBooks(borrowedBooks,personLoggedIn.getEmail());
        context.redirect(Routes.HOME);
    };
}
