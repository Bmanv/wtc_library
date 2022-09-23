package weshare.controller;

import io.javalin.http.Handler;
import weshare.model.Person;
import weshare.persistence.PersonDAO;
import weshare.server.Routes;
import weshare.server.ServiceRegistry;
import weshare.server.WeShareServer;

import java.util.Objects;

public class UserController {

    public static final Handler new_user = context -> {
//        context.sessionAttribute(WeShareServer.SESSION_USER_KEY, null);
        context.render("registerUser.html");
    };

    public static final Handler registerUser = context -> {
        Person personLoggedIn = WeShareServer.getPersonLoggedIn(context);

        String firstname = context.formParamAsClass("firstname", String.class)
                .check(Objects::nonNull, "Firstname is required")
                .get();
        String lastname = context.formParamAsClass("lastname", String.class)
                .check(Objects::nonNull, "Lastname is required")
                .get();
        String email = context.formParamAsClass("email", String.class)
                .check(Objects::nonNull, "Email is required")
                .get();
        String password = context.formParamAsClass("password", String.class)
                .check(Objects::nonNull, "password is required")
                .get();

        PersonDAO personDAO = ServiceRegistry.lookup(PersonDAO.class);
        Person person = new Person(email,firstname,lastname,password);
        personDAO.savePerson(person);

        context.redirect(Routes.LOGIN_PAGE);
    };
}
