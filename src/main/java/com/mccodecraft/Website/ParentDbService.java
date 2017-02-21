package com.mccodecraft.Website;

import java.util.Date;

/**
 * Created by james on 2/20/17.
 */
public interface ParentDbService<T> {
    public Boolean create(T entity);
    public Boolean update( Integer pId, String pName, String fName, String lName, String pWord, Date joinDate );
    public Boolean delete(Integer pId);
}
