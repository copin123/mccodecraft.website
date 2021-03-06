package com.mccodecraft.Website.DbService;

import java.util.Date;

/**
 * Created by james on 2/20/17.
 */
public interface ParentDbService<T> {
    Integer create(T entity);
    T read(Integer pID);
    Boolean update( Integer pId, String pName, String fName, String lName, String pWord );
    Boolean delete(  Integer pId  );
}
