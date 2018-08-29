package apple.mapper;

import apple.model.Apple;

import java.util.List;

public interface AppleMapper {

    List<Apple> all();

    Apple getAppleById(String id);

    void add(Apple apple);
}
