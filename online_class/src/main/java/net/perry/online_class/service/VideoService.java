package net.perry.online_class.service;

import java.util.List;

import net.perry.online_class.domain.Video;
import net.perry.online_class.domain.VideoBanner;

public interface VideoService {
    
    List<Video> listVideo();

    List<VideoBanner> listVideoBanner();

    Video findDetailById(int videoId);
}
