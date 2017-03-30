package com.mccodecraft.Website.Servlet;

import com.mccodecraft.Website.DbObjects.Parent;
import com.mccodecraft.Website.DbService.ParentDbService;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by james on 2/20/17.
 */
public class ParentServletDao<T extends Parent>  implements ParentDbService<T> {
    ArrayList<T> parentObj;
    public ParentServletDao() { parentObj = new ArrayList<T>(); }

    @Override
    public Integer create(T entity) {
        parentObj.add(entity);
        return null;
    }

    @Override
    public T read(Integer pID) {
        return parentObj.get(pID);
    }

    @Override
    public Boolean update(Integer pId, String pName, String fName, String lName, String pWord) {
        T entity = parentObj.get(pId);
        // re insert new object with sam pId.
        Parent parent = new Parent(pId)
                .setpName(pName)
                .setfName(fName)
                .setlName(lName)
                .setpWord(pWord);
        return true;
    }

    @Override
    public Boolean delete(Integer pId) {
         Parent parentBuilder = new Parent(pId);
         parentBuilder.setIsDeleted(true);
        return true;
    }
}
