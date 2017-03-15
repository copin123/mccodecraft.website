package com.mccodecraft.Website.DbService;

import java.util.Date;

/**
 * Created by james on 3/14/17.
 */
public interface StudentDbService<T> {
    Integer create(T entity);

    T read(Integer sID);

    Boolean update(Integer pId, Integer sId, String psName, String fsName, String lsName, String psWord, Date sjoinDate);

    Boolean delete(Integer sId);
}
