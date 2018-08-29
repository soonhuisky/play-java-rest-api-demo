package controllers;

import play.mvc.*;

import java.util.concurrent.CompletableFuture;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    public Result index() {
        return ok("service is ok");
    }

    public CompletableFuture<Result> hello(){
        return CompletableFuture.supplyAsync(() -> {
            return ok("hello world");
        });
    }
}
