package net.perry.online_class.mapper;

import net.perry.online_class.model.entity.PlayRecord;

public interface PlayRecordMapper {
    
    /**
     * 保存播放记录
     * @param playRecord
     * @return
     */
    int saveRecord(PlayRecord playRecord); 
}
