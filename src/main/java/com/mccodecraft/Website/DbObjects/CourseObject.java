package com.mccodecraft.Website.DbObjects;

import javax.persistence.Column;

/**
 * Created by james on 3/14/17.
 */
public class CourseObject {
//    public static Integer COURSE_INCREMENT_SIZE = 100;
//
//    public static Integer createQuantifiedVideoID(Integer videoID, Integer courseID) {
//        return courseID * COURSE_INCREMENT_SIZE + videoID;
//    }


    @Column(name = "courseId")
    private Integer courseId;
    @Column(name = "courseName")
    private String courseName;
    @Column(name = "courseDesc")
    private String courseDesc;

    public Integer getCourseId() {
        return courseId;
    }

    public CourseObject setCourseId(Integer courseId) {
        this.courseId = courseId;
        return this;
    }

    public String getCourseName() {
        return courseName;
    }

    public CourseObject setCourseName(String courseName) {
        this.courseName = courseName;
        return this;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public CourseObject setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
        return this;
    }
}



