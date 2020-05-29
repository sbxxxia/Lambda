package com.lambda.web.music;

import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity(name="music")
@Component @Lazy
public class Music {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long musicNo;

    @Column(length = 4, nullable = false)
    private String seq;
    @Column(length = 30, nullable = false)
    private String title;
    @Column(length = 100, nullable = false)
    private String artist;
    @Column(length = 200, nullable = false)
    private String thumbnail;

    @Builder
    public Music(String seq, String title, String artist, String thumbnail) {
        this.seq = seq;
        this.title = title;
        this.artist = artist;
        this.thumbnail = thumbnail;
    }

    public Music() {
    }

    public void setMusicNo(Long musicNo) {
        this.musicNo = musicNo;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Long getMusicNo() {
        return musicNo;
    }

    public String getSeq() {
        return seq;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
