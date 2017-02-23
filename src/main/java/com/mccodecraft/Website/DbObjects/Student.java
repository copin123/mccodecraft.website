package com.mccodecraft.Website.DbObjects;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by james on 2/20/17.
 */
public class Student {
    private Integer pID;
    private Integer sID;
    private String pName;
    private String fName;
    private String lName;
    private String pWord;
    private Date joinDate;
    private Boolean isDeleted;
    private Date dateDeleted;

    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");


    public Student(Integer pId, Integer sId, String pName, String fName, String lName, String pWord, Date joinDate, Boolean isDeleted, Date dateDeleted) {
        this.pID = pId;
        this.sID = sId;
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

    public Student setpID(Integer pID) {
        this.pID = pID;
        return this;
    }

    public Integer getSId() { return sID; }
    public Student setSId( Integer sId) {
        this.sID = sId;
        return this;
    }


    public String getpName() {
        return pName;
    }

    public Student setpName(String pName) {
        this.pName = pName;
        return this;
    }

    public String getfName() {
        return fName;
    }

    public Student setfName(String fName) {
        this.fName = fName;
        return this;
    }

    public String getlName() {
        return lName;
    }

    public Student setlName(String lName) {
        this.lName = lName;
        return this;
    }

    public String getpWord() {
        return pWord;
    }

    public Student setpWord(String pWord) {
        this.pWord = pWord;
        return this;
    }

    public String getStrngJoinDate() {
        return dateFormat.format(joinDate);
    }
    public Date getDateJoinDate() {
        return joinDate;
    }

    public Student setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
        return this;
    }
    public Student setJoinDate(String joinDate) {
        try {
            this.joinDate = dateFormat.parse(joinDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return this;

    }
    public Student setIsDeleted() {
        this.isDeleted = true;
        this.dateDeleted = new Date();
        return this;
    }
    public Boolean isDeleted() {
        return this.isDeleted;
    }


}
