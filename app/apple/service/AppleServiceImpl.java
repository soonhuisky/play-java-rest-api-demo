package apple.service;

import apple.mapper.AppleMapper;
import apple.model.Apple;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class AppleServiceImpl implements AppleService {

    private static final Logger logger = LoggerFactory.getLogger(AppleServiceImpl.class);

    @Inject
    private AppleMapper appleDao;

    @Override
    public CompletionStage<List<Apple>> list() {
        logger.info("service list apple first");
        return CompletableFuture.supplyAsync(() -> {
            //do block IO
            logger.info("service list apple end");
            return appleDao.all();
        });
    }

    @Override
    public CompletionStage<Optional<Apple>> getByid(String id) {
        return CompletableFuture.supplyAsync(() -> {
            //do block IO
            return Optional.ofNullable(appleDao.getAppleById(id));
        }).exceptionally(x -> Optional.empty());
    }

    @Override
    public CompletionStage<Optional<Apple>> add(Apple apple) {
        return CompletableFuture.supplyAsync(() -> {
            //do block IO
            appleDao.add(apple);
            return Optional.of(apple);
        }).exceptionally(x -> {
            logger.error("add new apple error: {}", x);
            return Optional.empty();
        });
    }

    @Override
    public CompletionStage<Boolean> delete(String id) {
        return null;
    }

    @Override
    public CompletionStage<Optional<Apple>> update(Apple apple) {
        return null;
    }
}
