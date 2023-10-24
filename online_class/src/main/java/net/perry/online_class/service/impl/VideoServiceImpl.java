package net.perry.online_class.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.perry.online_class.config.CacheKeyManager;
import net.perry.online_class.mapper.VideoMapper;
import net.perry.online_class.model.entity.Video;
import net.perry.online_class.model.entity.VideoBanner;
import net.perry.online_class.service.VideoService;
import net.perry.online_class.utils.BaseCache;

@Service
public class VideoServiceImpl implements VideoService{

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private BaseCache baseCache;

    @Override
    public List<Video> listVideo() {
        
        try {
            
            Object cacheObject = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_VIDEO_LIST_KEY, ()->{

                List<Video> videoList = videoMapper.listVideo();
                //没走缓存
                return videoList;

            });

            if (cacheObject instanceof List){

                List<Video> videoList = (List<Video>) cacheObject;
                return videoList;

            }
        } catch (Exception e) {            
            e.printStackTrace();
        }

        //可以返回兜底数据，业务降级
        return null;
    }

    @Override
    public List<VideoBanner> listVideoBanner() {
        try{
            Object cacheObject =  baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_BANNER_LIST_KEY, ()->{

                List<VideoBanner> bannerList = videoMapper.listVideoBanner();
                //没走缓存
                System.out.println("没走");
                return bannerList;

            });
            if(cacheObject instanceof List){

                List<VideoBanner> bannerList = (List<VideoBanner>) cacheObject;
                System.out.println("走了");
                return bannerList;

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Video findDetailById(int videoId) {

        try {
            
            String videoCacheKey = String.format(CacheKeyManager.VIDEO_DETAIL_KEY, videoId);
            Object cacheobject = baseCache.getOneHourCache().get(videoCacheKey, ()->{
                
                Video video = videoMapper.findDetailById(videoId);  
                //没走缓存      
                return video;

            });
            if (cacheobject instanceof Video){

                Video video = (Video) cacheobject;
                return video;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
