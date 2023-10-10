package net.perry.online_class.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.perry.online_class.domain.Video;
import net.perry.online_class.service.impl.VideoServiceImpl;
import net.perry.online_class.utils.JsonData;

@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoServiceImpl videoServiceImpl;

    @RequestMapping("list")
    public JsonData listVideo(){
        
        List<Video> videoList = videoServiceImpl.listVideo();
        return JsonData.buildSuccess(videoList);
    } 
    
}
