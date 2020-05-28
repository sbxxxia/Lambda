package com.lambda.web.soccer;

import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="team")
@Component @Lazy
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamNo;

    @NotNull @Column(length = 10)
    private String teamId;

    @Column(length = 10) private String regionName, origYyyy, zipCode1, zipCode2, ddd, tel, fax, owner;
    @Column(length = 40) private String teamName;
    @Column(length = 50) private String eTeamName, homepage;
    @Column(length = 80) private String address;

    @OneToMany(mappedBy = "team")
    private List<Player> playerList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stadium_id") @NotNull
    private Stadium stadium;

    @Builder
    public Team(String teamId, String regionName, String teamName, String eTeamName, String origYyyy, String zipCode1,
                String zipCode2, String address, String ddd, String tel, String fax,
                String homepage, String owner) {
        this.teamId = teamId;
        this.regionName = regionName;
        this.teamName = teamName;
        this.eTeamName = eTeamName;
        this.origYyyy = origYyyy;
        this.zipCode1 = zipCode1;
        this.zipCode2 = zipCode2;
        this.address = address;
        this.ddd = ddd;
        this.tel = tel;
        this.fax = fax;
        this.homepage = homepage;
        this.owner = owner;
    }
}
