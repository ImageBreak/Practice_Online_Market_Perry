package net.perry.online_class.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.perry.online_class.domain.Video;
import net.perry.online_class.domain.VideoBanner;
import net.perry.online_class.service.impl.VideoServiceImpl;
import net.perry.online_class.utils.JsonData;

@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoServiceImpl videoServiceImpl;

    /**
     * 轮播图列表
     * @return
     */
    @GetMapping("list_banner")
    public JsonData indexBanner(){
        
        List<VideoBanner> bannerList = videoServiceImpl.listVideoBanner();

        return JsonData.buildSuccess(bannerList);
    }

    /**
     * 视频列表
     * @return
     */
    @RequestMapping("list")
    public JsonData listVideo(){
        
        List<Video> videoList = videoServiceImpl.listVideo();
        return JsonData.buildSuccess(videoList);
    } 
    
    /**
     * 查询视频详情，包含章，集信息
     * @param videoId
     * @return
     */
    @GetMapping("find_detail_by_id")
    public JsonData findDetailById(@RequestParam(value = "video_id", required = true)int videoId){
        
        Video video = videoServiceImpl.findDetailById(videoId);
        
        return JsonData.buildSuccess(video);
    }
}
