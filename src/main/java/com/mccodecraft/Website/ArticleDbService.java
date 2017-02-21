package com.mccodecraft.Website;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by james on 2/7/17.
 */
public interface ArticleDbService<T> {
    public Boolean create(T entity);
    public T readOne(int id);
    public ArrayList<T> readAll();
    public Boolean update(int id, String title, String summary, String content, Date date, Boolean delete);
    public Boolean delete(int id);
}
