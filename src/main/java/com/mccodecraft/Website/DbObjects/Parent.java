package com.mccodecraft.Website.DbObjects;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by james on 2/20/17.
 */
public class Parent {
    private Integer pID;
    private String pName;
    private String fName;
    private String lName;
    private String pWord;
    private Date joinDate;
    private Boolean isDeleted;
    private Date dateDeleted;

    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");


    public Parent(Integer pId, String pName, String fName, String lName, String pWord, Date joinDate, Boolean isDeleted, Date dateDeleted) {
        this.pID = pId;
        this.pName = pName;
        this.fName = fName;
        this.lName = lName;
        this.pWord = pWord;
        this.joinDate = joinDate;
        this.isDeleted = isDeleted;
        this.dateDeleted = dateDeleted;
    }

    public Integer getpID() {
        return pID;
    }

    public Parent setpID(Integer pID) {
        this.pID = pID;
        return this;
    }

    public String getpName() {
        return pName;
    }

    public Parent setpName(String pName) {
        this.pName = pName;
        return this;
    }

    public String getfName() {
        return fName;
    }

    public Parent setfName(String fName) {
        this.fName = fName;
        return this;
    }

    public String getlName() {
        return lName;
    }

    public Parent setlName(String lName) {
        this.lName = lName;
        return this;
    }

    public String getpWord() {
        return pWord;
    }

    public Parent setpWord(String pWord) {
        this.pWord = pWord;
        return this;
    }

    public String getStrngJoinDate() {
        return dateFormat.format(joinDate);
    }
    public Date getDateJoinDate() {
        return joinDate;
    }

    public Parent setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
        return this;
    }
    public Parent setJoinDate(String joinDate) {
        try {
            this.joinDate = dateFormat.parse(joinDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return this;

    }
    public Parent setIsDeleted() {
        this.isDeleted = true;
        this.dateDeleted = new Date();
        return this;
    }
    public Boolean isDeleted() {
        return this.isDeleted;
    }


}
