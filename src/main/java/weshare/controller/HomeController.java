package weshare.controller;

import io.javalin.http.Handler;


public class HomeController {

    public static final Handler view = context -> {
        context.render("home.html");
    };
}
