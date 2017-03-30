package com.mccodecraft.Website.DbObjects;

import javax.persistence.*;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by james on 2/20/17.
 */
@Entity
@Table(name = "student")
public class Student implements Serializable{

    public Student() {}


    @Id
    @GeneratedValue
    @Column(name = "STUDENT_ID")
    private Integer sID;
//    @ManyToOne
//    @JoinColumn(name="pID", foreignKey = @ForeignKey(name = "student_parent_FK"))
//    Hibernate book 263
    @Column(name = "studentName")
    private String psName;
    @Column(name = "studentFName")
    private String fsName;
    @Column(name = "studentLName")
    private String lsName;
    @Column(name = "studentPWord")
    private String psWord;
    @Column(name = "sjoinDate")
    private Date sjoinDate;
    @Column(name = "studentIsDeleted")
    private Boolean sisDeleted;
    @Column(name = "studentDeleteDate")
    private Date dateDeleted;




    public Student(Integer sID) {
        this.sID = sID;
    }

    public Integer getSId() {
        return this.sID;
    }

    public String getpName() {
        return psName;
    }

    public String getfName() {
        return fsName;
    }

    public String getlName() {
        return lsName;
    }

    public String getpWord() {
        return psWord;
    }

    public Boolean getIsDeleted() {
        return sisDeleted;
    }

    public Date getDateJoinDate() {
        return sjoinDate;
    }

    public Boolean isDeleted() {
        return this.sisDeleted;
    }

    // adding for hibernate

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

    public Student setJoinDateString(String joinDate) {
        try {
            this.sjoinDate = new SimpleDateFormat("MM/dd/yyyy").parse(joinDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Student setJoinDate() {
        this.sjoinDate = new Date();
        return this;
    }

    public Student setIsDeleted(boolean isDeleted) {
        this.sisDeleted = isDeleted;
        this.dateDeleted = (isDeleted) ? new Date() : null;
        return this;
    }



}
