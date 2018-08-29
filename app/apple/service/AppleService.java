package apple.service;

import apple.model.Apple;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletionStage;

public interface AppleService {

    CompletionStage<List<Apple>> list();

    CompletionStage<Optional<Apple>> getByid(String id);

    CompletionStage<Optional<Apple>> add(Apple apple);

    CompletionStage<Boolean> delete(String id);

    CompletionStage<Optional<Apple>> update(Apple apple);
}
