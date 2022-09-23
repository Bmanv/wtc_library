package weshare.server;

import weshare.controller.*;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.post;

public class Routes {
    public static final String LOGIN_PAGE = "/";
    public static final String LOGIN_ACTION = "/login.action";
    public static final String LOGOUT = "/logout";
    public static final String HOME = "/home";
    public static final String VIEW_BOOKS ="/viewbooks";


    public static final String REGISTER_USER = "/registeruser";
    public static final String REGISTER_USER_ACTION = "/registeruser.action";

    public static final String VIEW_BORROWED_BOOKS ="/borrowedbooks";

    public static final String VIEW_BOOK ="/bookdetails";
    public static final String BORROW_BOOK ="/bookdetails.action";

    public static final String READ_BOOK ="/readbook";
    public static final String RETURN_BOOK ="/readbook.action";

    public static void configure(WeShareServer server) {
        server.routes(() -> {
            post(LOGIN_ACTION,  PersonController.login);
            get(LOGOUT,         PersonController.logout);
            get(HOME,           HomeController.view);
            get(VIEW_BOOKS,           ViewBookController.view);



            get(REGISTER_USER,           UserController.new_user);
            post(REGISTER_USER_ACTION,           UserController.registerUser);


            get(VIEW_BOOK, ViewBookController.viewBook);
            get(VIEW_BORROWED_BOOKS, BorrowedBooksController.view);
            get(READ_BOOK, BorrowedBooksController.readBook);
            post(RETURN_BOOK, BorrowedBooksController.returnBook);
            post(BORROW_BOOK, ViewBookController.borrowBook);

        });
    }
}
