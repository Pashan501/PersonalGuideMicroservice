package com.personalguide.api.repository;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {
    Optional<T> getById(int id);

    List<T> getAll();
}
