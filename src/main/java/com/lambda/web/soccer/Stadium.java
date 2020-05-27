package com.lambda.web.soccer;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="stadium")
@Component
public class Stadium {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stadiumNo;

    @NotNull @Column(length = 10) private String stadiumId;
    @Column(length = 10) private String hometeamId, seatCount, ddd, tel;
    @Column(length = 40) private String stadiumName;
    @Column(length = 60) private String address;

    @OneToMany(mappedBy = "stadium")
    private List<Team> teamList;

    @OneToMany(mappedBy = "stadium")
    private List<Schedule> scheduleList;

    @Builder
    public Stadium(String stadiumId, String stadiumName, String hometeamId, String seatCount,
                   String address, String ddd, String tel){
        this.stadiumId = stadiumId;
        this.stadiumName = stadiumName;
        this.hometeamId = hometeamId;
        this.seatCount = seatCount;
        this.address = address;
        this.ddd = ddd;
        this.tel = tel;
    }
}
