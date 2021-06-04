package com.personalguide.api.services;

import java.util.List;
import java.util.Locale;

public interface Service<T,K> {
    List<T> getAll(Locale locale);

    T getById(int id,Locale locale);
}
