package com.greymatter.gmpetclinic.services;

import java.util.Set;

public interface CrudService<T, ID>  {
    Set<T> findAll();
    T findById(Long id);
    T save(T object);
    void delete(T object);
}
