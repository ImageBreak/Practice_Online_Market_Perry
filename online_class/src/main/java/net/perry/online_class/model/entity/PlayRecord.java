package net.perry.online_class.model.entity;

import java.util.Date;

public class PlayRecord {
    
    private Integer id;

    private Integer userId;

    private Integer videoId;

    private Integer currentNum;

    private Integer episodeId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(Integer currrentNum) {
        this.currentNum = currrentNum;
    }

    public Integer getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(Integer episodeId) {
        this.episodeId = episodeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "PlayRecord [id=" + id + ", userId=" + userId + ", videoId=" + videoId + ", currrentNum=" + currentNum
                + ", episodeId=" + episodeId + ", createTime=" + createTime + "]";
    }

    
}