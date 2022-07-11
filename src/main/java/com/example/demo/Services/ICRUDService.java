package com.example.demo.Services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ICRUDService<T> {
    Optional<T> findById(Integer id);
    T create(T t);
    void deleteById(Integer id);
    T update(T t);
    List<T> findAll();
}
