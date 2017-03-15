package com.mccodecraft.Website.DbObjects;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;


import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by james on 2/20/17.
 */
@Entity
@Table(name = "parent")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pID")
    private Integer pID;
    @Column(name = "pName")
    private String pName;
    @Column(name = "fName")
    private String fName;
    @Column(name = "lName")
    private String lName;
    @Column(name = "pWord")
    private String pWord;
    @Column(name = "joinDate")
    private Date joinDate;
    @Column(name = "isDeletee")
    private Boolean isDeleted;
    @Column(name = "deleteDate")
    private Date dateDeleted;

    public Parent() {}

    public Integer getpID() {
        return pID;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getpName() {
        return pName;
    }

    public String getpWord() {
        return pWord;
    }

    public String getStringJoinDate() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.format(joinDate);
    }

    public Date getDateJoinDate() {
        return joinDate;
    }

    public Boolean isDeleted() {
        return this.isDeleted;
    }

    public Parent(Integer pId) {
        this.pID = pId;
    }

    public Parent setpID(Integer pID) {
        this.pID = pID;
        return this;
    }

    public Parent setpName(String pName) {
        this.pName = pName;
        return this;
    }

    public Parent setfName(String fName) {
        this.fName = fName;
        return this;
    }

    public Parent setlName(String lName) {
        this.lName = lName;
        return this;
    }

    public Parent setpWord(String pWord) {
        this.pWord = pWord;
        return this;
    }

    public Parent setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
        return this;
    }

    public Parent setJoinDateString(String joinDateString) {
        try {
            this.joinDate = new SimpleDateFormat("MM/dd/yyyy").parse(joinDateString);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return this;
    }

    public Parent setJoinDate() {
        this.joinDate = new Date();
        return this;
    }

    public Parent setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
        this.dateDeleted = (isDeleted) ? new Date() : null;
        return this;
    }

}
