package com.lambda.web.soccer;

import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity(name="player")
@Lazy
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

    public Player() {
    }

    public Long getPlayerNo() {
        return playerNo;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getePlayerName() {
        return ePlayerName;
    }

    public String getNickname() {
        return nickname;
    }

    public String getJoinYyyy() {
        return joinYyyy;
    }

    public String getPosition() {
        return position;
    }

    public String getBackNo() {
        return backNo;
    }

    public String getNation() {
        return nation;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getSolar() {
        return solar;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public Team getTeam() {
        return team;
    }

    public void setPlayerNo(Long playerNo) {
        this.playerNo = playerNo;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setePlayerName(String ePlayerName) {
        this.ePlayerName = ePlayerName;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setJoinYyyy(String joinYyyy) {
        this.joinYyyy = joinYyyy;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setBackNo(String backNo) {
        this.backNo = backNo;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setSolar(String solar) {
        this.solar = solar;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
