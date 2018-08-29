package apple.controller;

import apple.model.Apple;
import apple.service.AppleService;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.Collections;
import java.util.concurrent.CompletionStage;

public class AppleController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger(AppleController.class);

    private final AppleService appleService;

    @Inject
    public AppleController(AppleService appleService) {
        this.appleService = appleService;
    }


    public CompletionStage<Result> list() {
        logger.info("controller list apple first");
        return appleService.list()
                .thenApply(x -> {
                    logger.info("controller list apple end");
                    return ok(Json.toJson(Collections.singletonMap("apples", x)));
                });
    }


    public CompletionStage<Result> getById(String id) {
        return appleService.getByid(id)
                .thenApply(x -> x.map(y -> ok(Json.toJson(y)))
                        .orElse(notFound()));
    }


    public CompletionStage<Result> add() {
        JsonNode body = request().body().asJson();
        logger.info("add new apple body is : {}", body);
        Apple apple = Json.fromJson(body, Apple.class);
        return appleService.add(apple)
                .thenApply(x -> x.map(y -> ok(Json.toJson(y)))
                .orElse(internalServerError()));
    }
}
