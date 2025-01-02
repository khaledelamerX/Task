package org.example.service;

import java.util.List;

public interface CRUDInterface<T> {
    List<T> getAll();

    T getById(Long id);

    void deleteById(Long id);

    T create(T t);

    T updateById(T t, Long id);

    String getName(String isoCode);
}
