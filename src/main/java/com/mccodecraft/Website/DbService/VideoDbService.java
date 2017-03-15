package com.mccodecraft.Website.DbService;

/**
 * Created by james on 3/14/17.
 */
public interface VideoDbService<T> {
    Integer create(T entity);
    T read(Integer vID);
    Boolean update (T entity);
}
