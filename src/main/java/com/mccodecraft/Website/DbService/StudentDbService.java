package com.mccodecraft.Website.DbService;

import com.mccodecraft.Website.DbObjects.Parent;

import java.util.Date;

/**
 * Created by james on 3/14/17.
 */
public interface StudentDbService<S, T> {
    Integer create(S thing, T entity);
    T read(Integer sID);
    Boolean update(Parent parent, Integer sId, String psName, String fsName, String lsName, String psWord, Date joinDate);
    Boolean delete(Integer sId);
}
