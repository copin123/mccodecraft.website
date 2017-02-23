package com.mccodecraft.Website.DbObjects;

/**
 * Created by james on 2/22/17.
 */
public class AccountInfo {
    /* business logic is:
       One student: $10
       Two to Four: $20
       Five plus:  $5 per kid

       business logic in code to limit number of students based on numStudents.

     */
    private String payMethod;
    private Integer pId;
    private Integer numStudents;
    private Integer sId;
    private Integer studentCount;

    public Integer getpId() {
        return pId;
    }

    public AccountInfo setpId(Integer pId) {
        this.pId = pId;
        return this;
    }

    public Integer getNumStudents() {
        return numStudents;
    }

    public AccountInfo setNumStudents(Integer numStudents) {
        this.numStudents = numStudents;
        return this;
    }

    public Integer getsId() {
        return sId;
    }

    public AccountInfo setsId(Integer sId) {
        this.sId = sId;
        return this;
    }

    public Integer getStudentCount() {
        return studentCount;
    }

    public AccountInfo setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
        return this;
    }

    public String getPayMethod() {
        return payMethod;
    }
    public AccountInfo setPayMethod(String payMethod) {
        this.payMethod = payMethod;
        return this;
    }


}
