package com.mccodecraft.Website.DbObjects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by james on 2/24/17.
 */
public class VideoObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "videoID")
    private Integer videoId;
//    @Column(name = "quantifiedVideoID")
//    private Integer quantifiedVideoID;
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

    public String getVideoName() {
        return videoName;
    }

//    public Integer getQuantifiedVideoID() {
//        if(quantifiedVideoID < 100) {
//            setQuantifiedVideoID(CourseObject.createQuantifiedVideoID(this.videoId, this.courseId));
//            return quantifiedVideoID;
//        } else {
//            return quantifiedVideoID;
//        }
//    }
//
//    public VideoObject setQuantifiedVideoID(Integer quantifiedVideoID) {
//        this.quantifiedVideoID = quantifiedVideoID;
//        return this;
//    }

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
