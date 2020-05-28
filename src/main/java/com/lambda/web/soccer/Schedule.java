package com.lambda.web.soccer;

import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.persistence.*;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="schedule")
@Component @Lazy
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheNo;

    @NotNull @Column(length = 10)
    private String scheDate;

    @Column(length = 10) private String gubun, hometeamId, awayteamId, homeScore, awayScore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stadium_id") @NotNull
    private Stadium stadium;

    @Builder
    public Schedule(String scheDate, String gubun, String hometeamId, String awayteamId, String homeScore, String awayScore) {
        this.scheDate = scheDate;
        this.gubun = gubun;
        this.hometeamId = hometeamId;
        this.awayteamId = awayteamId;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }
}
