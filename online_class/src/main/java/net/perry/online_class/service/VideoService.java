package net.perry.online_class.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.perry.online_class.domain.Video;
import net.perry.online_class.domain.VideoBanner;

@Service
public interface VideoService {
    
    List<Video> listVideo();

    List<VideoBanner> listVideoBanner();

    Video findDetailById(int videoId);
}
