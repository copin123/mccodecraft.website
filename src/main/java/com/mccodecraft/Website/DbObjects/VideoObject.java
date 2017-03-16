package com.mccodecraft.Website.DbObjects;

import javax.persistence.*;

/**
 * Created by james on 2/24/17.
 */
@Entity
@Table(name = "videos")
public class VideoObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "videoID")
    private Integer videoId;
    @ManyToOne
    @JoinColumn(name = "courseID")
    private Integer courseID;
    @Column(name = "videoName")
    private String videoName;
    @Column(name = "videoDesc")
    private String videoDesc;
    @Column(name = "youtubeLink")
    private String youtubeLink;

    public Integer getVideoId() {
        return videoId;
    }

    public VideoObject setVideoId(Integer videoId) {
        this.videoId = videoId;
        return this;
    }

    public Integer getCourseId() {
        return courseID;
    }

    public VideoObject setCourseId(Integer courseId) {
        this.courseID = courseId;
        return this;
    }

    public String getVideoName() {
        return videoName;
    }

    public VideoObject setVideoName(String videoName) {
        this.videoName = videoName;
        return this;
    }

    public String getVideoDesc() {
        return videoDesc;
    }

    public VideoObject setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc;
        return this;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public VideoObject setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
        return this;
    }


}
