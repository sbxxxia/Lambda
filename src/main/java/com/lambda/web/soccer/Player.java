package com.lambda.web.soccer;

import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity(name="player")
public class Player {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerNo;

    @NotNull @Column(length = 10)
    private String playerId;

    @Column(length = 15)
    private String playerName, ePlayerName, nickname, joinYyyy, position, backNo, nation, birthDate, solar, height, weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @Builder
    public Player(String playerId, String playerName, String ePlayerName, String nickname, String joinYyyy,
                  String position, String backNo, String nation, String birthDate, String solar, String height,
                  String weight) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.ePlayerName = ePlayerName;
        this.nickname = nickname;
        this.joinYyyy = joinYyyy;
        this.position = position;
        this.backNo = backNo;
        this.nation = nation;
        this.birthDate = birthDate;
        this.solar = solar;
        this.height = height;
        this.weight = weight;
    }
}
