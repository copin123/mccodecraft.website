package com.mccodecraft.Website.DbObjects;
import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by james on 2/20/17.
 */
@Entity
@Table(name = "parent")
public class Parent implements Serializable{

    public Parent(){}

    public Parent(Integer parentID, List<Student> studentList) {
        this.pID = parentID;
        this.studentList = studentList;
    }

    @Id
    @GeneratedValue
    @Column(name = "PARENT_ID")
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

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "PARENT_STUDENTS", joinColumns = {@JoinColumn(name="PARENT_ID")}, inverseJoinColumns =  {@JoinColumn(name="STUDENT_ID")})
    private List<Student> studentList = new ArrayList<>();

    public List<Student> getStudentList() {
        return this.studentList;
    }
    public Parent setStudents(List<Student> students) {
        this.studentList= students;
        return this;
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

//    public String getStringJoinDate() {
//        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
//        return dateFormat.format(joinDate);
//    }

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

//    public Parent setJoinDateString(String joinDateString) {
//        try {
//            this.joinDate = new SimpleDateFormat("MM/dd/yy").parse(joinDateString);
//        } catch (ParseException ex) {
//            ex.printStackTrace();
//        }
//        return this;
//    }
//
//    public Parent setJoinDate() {
//        this.joinDate = new Date();
//        return this;
//    }

    public Parent setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
        this.dateDeleted = (isDeleted) ? new Date() : null;
        return this;
    }

}
