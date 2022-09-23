package weshare.controller;

import io.javalin.http.Handler;
import weshare.model.Person;
import weshare.persistence.PersonDAO;
import weshare.server.Routes;
import weshare.server.ServiceRegistry;
import weshare.server.WeShareServer;

import java.util.Objects;

public class PersonController {

    public static final Handler logout = ctx -> {
        ctx.sessionAttribute(WeShareServer.SESSION_USER_KEY, null);
        ctx.redirect(Routes.LOGIN_PAGE);
    };

    private static final PersonDAO personDAO = ServiceRegistry.lookup(PersonDAO.class);
    public static final Handler login = context -> {
        String email = context.formParamAsClass("email", String.class)
                .check(Objects::nonNull, "Email is required")
                .get();
        String password = context.formParamAsClass("password", String.class)
                .check(Objects::nonNull, "Password is required")
                .get();

        if (personDAO.login(email, password)) {
            context.sessionAttribute(WeShareServer.SESSION_USER_KEY,
                    personDAO.findPersonByEmail(email).get());
        }
        context.redirect(Routes.HOME);
    };
}
