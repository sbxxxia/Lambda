package com.lambda.web.mappers;

import com.lambda.web.music.MusicDTO;
import com.lambda.web.proxy.Pager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicMapper {
    public void insertMusic(MusicDTO music);
    public void updateMusic(MusicDTO music);
    public void deleteMusic(MusicDTO music);
    public List<MusicDTO> selectMusics(Pager pager);
    public MusicDTO selectMusic(String musicSeq);
    public int count();
}
