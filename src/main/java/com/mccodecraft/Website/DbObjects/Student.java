package com.mccodecraft.Website.DbObjects;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by james on 2/20/17.
 */
@DynamicUpdate
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pId")
    private  Integer pID;
    @Column(name = "sId")
    private Integer sID;
    @Column(name = "psName")
    private String psName;
    @Column(name = "fName")
    private String fsName;
    @Column(name = "lName")
    private String lsName;
    @Column(name = "pWord")
    private String psWord;
    @Column(name = "joinDate")
    private Date sjoinDate;
    @Column(name = "isDeleted")
    private Boolean sisDeleted;
    @Column(name = "dateDeleted")
    private Date dateDeleted;
    @Column(name = "currentCourse")
    private Integer currentCourse;
    @Column(name = "lastVideoViewed")
    private Integer lastVideoViewed;

    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");


    public Student(
            final Integer pId,
            final Integer sId,
            final String psName,
            final String fsName,
            final String lsName,
            final String psWord,
            final Date sjoinDate,
            final Boolean sisDeleted,
            final Date sdateDeleted,
            final Integer currentCourse,
            final Integer lastVideoViewed) {
//        this.pID = pId;
//        this.sID = sId;
//        this.pName = pName;
//        this.fName = fName;
//        this.lName = lName;
//        this.pWord = pWord;
//        this.joinDate = joinDate;
//        this.isDeleted = isDeleted;
//        this.dateDeleted = dateDeleted;
//        this.currentCourse = currentCourse;
//        this.lastVideoViewed = lastVideoViewed;
    }

    public Integer getpID() {return this.pID; }
    public Integer getSId() { return this.sID; }
    public String getpName() { return psName; }
    public String getfName() {
        return fsName;
    }
    public String getlName() {
        return lsName;
    }
    public String getpWord() {
        return psWord;
    }
    public String getStrngJoinDate() { return dateFormat.format(sjoinDate); }
    public Date getDateJoinDate() {
        return sjoinDate;
    }
    public Boolean isDeleted() {
        return this.sisDeleted;
    }
    public Integer getCurrentCourse() {
        return currentCourse;
    }
    public Integer getLastVideoViewed() {
        return lastVideoViewed;
    }

    // adding for hibernate

        public Student setpID(Integer pID) {
            this.pID = pID;
            return this;
        }

        public Student setSId(Integer sId) {
            this.sID = sId;
            return this;
        }

        public Student setpName(String pName) {
            this.psName = pName;
            return this;
        }

        public Student setfName(String fName) {
            this.fsName = fName;
            return this;
        }

        public Student setlName(String lName) {
            this.lsName = lName;
            return this;
        }

        public Student setpWord(String pWord) {
            this.psWord = pWord;
            return this;
        }

        public Student setJoinDate(Date joinDate) {
            this.sjoinDate = joinDate;
            return this;
        }

        public Student setJoinDate(String joinDate) {
            try {
                this.sjoinDate = new SimpleDateFormat("MM/dd/yyyy").parse(joinDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return this;
        }

        public Student setIsDeleted() {
            this.sisDeleted = true;
            this.dateDeleted = new Date();
            return this;
        }

        public Student setCurrentCourse(Integer currentCourse) {
            this.currentCourse = currentCourse;
            return this;
        }

        public Student setLastVideoViewed(Integer lastVideoViewed) {
            this.lastVideoViewed = lastVideoViewed;
            return this;
        }


//    public static class StudentBuilder {
//        private Integer pId;
//        private Integer sId;
//        private String pName;
//        private String fName;
//        private String lName;
//        private String pWord;
//        private Date joinDate;
//        private Boolean isDeleted;
//        private Date dateDeleted;
//        private Integer currentCourse;
//        private Integer lastVideoViewed;
//
//        public StudentBuilder(final Integer pId) {
//            this.pId = pId;
//        }
//
//        public StudentBuilder setpID(Integer pID) {
//            this.pId = pID;
//            return this;
//        }
//
//        public StudentBuilder setSId(Integer sId) {
//            this.sId = sId;
//            return this;
//        }
//
//        public StudentBuilder setpName(String pName) {
//            this.pName = pName;
//            return this;
//        }
//
//        public StudentBuilder setfName(String fName) {
//            this.fName = fName;
//            return this;
//        }
//
//        public StudentBuilder setlName(String lName) {
//            this.lName = lName;
//            return this;
//        }
//
//        public StudentBuilder setpWord(String pWord) {
//            this.pWord = pWord;
//            return this;
//        }
//
//        public StudentBuilder setJoinDate(Date joinDate) {
//            this.joinDate = joinDate;
//            return this;
//        }
//
//        public StudentBuilder setJoinDate(String joinDate) {
//            try {
//                this.joinDate = new SimpleDateFormat("MM/dd/yyyy").parse(joinDate);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            return this;
//        }
//
//        public StudentBuilder setIsDeleted() {
//            this.isDeleted = true;
//            this.dateDeleted = new Date();
//            return this;
//        }
//
//        public StudentBuilder setCurrentCourse(Integer currentCourse) {
//            this.currentCourse = currentCourse;
//            return this;
//        }
//
//        public StudentBuilder setLastVideoViewed(Integer lastVideoViewed) {
//            this.lastVideoViewed = lastVideoViewed;
//            return this;
//        }
//
//        public Student build() {
//            return new Student(pId,
//            sId,
//            pName,
//            fName,
//            lName,
//            pWord,
//            joinDate,
//            isDeleted,
//            dateDeleted,
//            currentCourse,
//            lastVideoViewed);
//        }
//    }
}
