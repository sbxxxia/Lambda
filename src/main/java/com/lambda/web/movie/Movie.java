package com.lambda.web.movie;

import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieSeq;

    @Column(length = 4)
    private String rank;
    @Column(length = 100)
    private String title;
    @Column(length = 10)
    private String rankDate;

    @Builder
    public Movie(String rank, String title, String rankDate) {
        this.rank = rank;
        this.title = title;
        this.rankDate = rankDate;
    }

    public Movie() {
    }

    public void setMovieSeq(Long movieSeq) {
        this.movieSeq = movieSeq;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRankDate(String rankDate) {
        this.rankDate = rankDate;
    }

    public Long getMovieSeq() {
        return movieSeq;
    }

    public String getRank() {
        return rank;
    }

    public String getTitle() {
        return title;
    }

    public String getRankDate() {
        return rankDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieSeq=" + movieSeq +
                ", rank='" + rank + '\'' +
                ", title='" + title + '\'' +
                ", rankDate='" + rankDate + '\'' +
                '}';
    }
}
