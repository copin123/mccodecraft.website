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
@Table(name = "PARENT")
public class Parent {
    @Id
    @GeneratedValue
    @Column(name = "pId")
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
    @Column(name = "isDeleted")
    private Boolean isDeleted;
    @Column(name = "dateDeleted")
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

    public String getStrngJoinDate() {
        return dateFormat.format(joinDate);
    }

    public Date getDateJoinDate() {
        return joinDate;
    }

    public Boolean isDeleted() {
        return this.isDeleted;
    }

    public static class ParentBuilder {
        private Integer pID;
        private String pName;
        private String fName;
        private String lName;
        private String pWord;
        private Date joinDate;
        private Boolean isDeleted;
        private Date dateDeleted;

        public ParentBuilder(Integer pId) {
            this.pID = pId;
        }

        public ParentBuilder setpID(Integer pID) {
            this.pID = pID;
            return this;
        }

        public ParentBuilder setpName(String pName) {
            this.pName = pName;
            return this;
        }

        public ParentBuilder setfName(String fName) {
            this.fName = fName;
            return this;
        }

        public ParentBuilder setlName(String lName) {
            this.lName = lName;
            return this;
        }

        public ParentBuilder setpWord(String pWord) {
            this.pWord = pWord;
            return this;
        }

        public ParentBuilder setJoinDate(Date joinDate) {
            this.joinDate = joinDate;
            return this;
        }

        public ParentBuilder setJoinDate(String joinDate) {
            try {
                this.joinDate = new SimpleDateFormat("MM/dd/yyyy").parse(joinDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return this;

        }

        public ParentBuilder setIsDeleted(boolean isDeleted) {
            this.isDeleted = isDeleted;
            this.dateDeleted =  (isDeleted)? new Date() : null;
            return this;
        }

        public Parent build() {
            return new Parent(pID,
                    pName,
                    fName,
                    lName,
                    pWord,
                    joinDate,
                    isDeleted,
                    dateDeleted);
        }
    }


}
