package net.perry.online_class.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.perry.online_class.domain.Video;
import net.perry.online_class.domain.VideoBanner;
import net.perry.online_class.mapper.VideoMapper;
import net.perry.online_class.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService{

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> listVideo() {
        
        return videoMapper.listVideo();
    }

    @Override
    public List<VideoBanner> listVideoBanner() {
        
        return videoMapper.listVideoBanner();
    }

    @Override
    public Video findDetailById(int videoId) {
        return videoMapper.findDetailById(videoId);
    }
    
}
