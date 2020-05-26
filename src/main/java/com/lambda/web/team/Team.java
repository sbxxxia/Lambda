package com.lambda.web.team;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;

    private String regionName, teamName, eTeamName, origYyyy, zipCode1, zipCode2, address, ddd, tel, fax,
            homepage, owner, stadiumId;

    @Builder
    public Team(String regionName, String teamName, String eTeamName, String origYyyy, String zipCode1,
                String zipCode2, String address, String ddd, String tel, String fax,
                String homepage, String owner, String stadiumId) {
        this.regionName = regionName;
        this.teamName = teamName;
        this.eTeamName = eTeamName;
        this.origYyyy = origYyyy;
        this.zipCode1 = zipCode1;
        this.zipCode2 = zipCode2;
        this.address = address;
        this.ddd = ddd;
        this.tel = fax;
        this.homepage = homepage;
        this.owner = owner;
        this.stadiumId = stadiumId;

    }
}
