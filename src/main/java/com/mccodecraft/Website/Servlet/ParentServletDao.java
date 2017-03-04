package com.mccodecraft.Website.Servlet;

import com.mccodecraft.Website.DbObjects.Parent;
import com.mccodecraft.Website.DbService.ParentDbService;

import java.util.ArrayList;

/**
 * Created by james on 2/20/17.
 */
public class ParentServletDao<T extends Parent>  implements ParentDbService<T> {
    ArrayList<T> parentObj;
    public ParentServletDao() { parentObj = new ArrayList<T>(); }

    @Override
    public Boolean create(T entity) {
        parentObj.add(entity);
        return null;
    }

    @Override
    public T read(Integer pID) {
        return parentObj.get(pID);
    }

    @Override
    public Boolean update(Integer pId, String pName, String fName, String lName, String pWord, String joinDate) {
        T entity = parentObj.get(pId);
        // re insert new object with sam pId.
        Parent.ParentBuilder parentBuilder = new Parent.ParentBuilder(pId);
            parentBuilder
                .setpID(pId)
                .setpName(pName)
                .setfName(fName)
                .setlName(lName)
                .setpWord(pWord)
                .setJoinDate(joinDate)
                .build();
        return true;
    }

    @Override
    public Boolean delete(Integer pId) {
         Parent.ParentBuilder parentBuilder = new Parent.ParentBuilder(pId);
         parentBuilder.setIsDeleted(true).build();
        return true;
    }
}
