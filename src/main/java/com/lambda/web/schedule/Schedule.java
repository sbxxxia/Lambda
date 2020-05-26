package com.lambda.web.schedule;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheDate;

    private String stadiumId, gubun, hometeamId, awayteamId, homeScore, awayScore;

    @Builder
    public Schedule(String stadiumId, String gubun, String hometeamId, String awayteamId, String homeScore, String awayScore) {
        this.stadiumId = stadiumId;
        this.gubun = gubun;
        this.hometeamId = hometeamId;
        this.awayteamId = awayteamId;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }
}
