package com.mccodecraft.Website.DbObjects;

import javax.persistence.Column;

/**
 * Created by james on 3/14/17.
 */
public class transcript {
    @Column(name = "currentCourse")
    private Integer currentCourse;
    @Column(name = "lastVideoViewed")
    private Integer lastVideoViewed;
}
