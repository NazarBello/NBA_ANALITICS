package com.nazarbello.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "player_season_stats")
public class PlayerSeasonStats {

    @Id
    private Long id;

    @Column(name = "seas_id", nullable = false)
    private Long seasId;

    @Column(nullable = false)
    private Integer season;

    @Column(name = "player_id", nullable = false)
    private Long playerId;

    private String player;
    private String pos;
    private Integer age;
    private Integer experience;
    private String lg;
    private String tm;

    @Column(name = "g")
    private Integer gamesPlayed;
    private Integer mp;
    private Double per;

    @Column(name = "ts_percent")
    private Double tsPercent;

    @Column(name = "x3p_ar")
    private Double x3pAr;

    @Column(name = "f_tr")
    private Double fTr;

    @Column(name = "orb_percent")
    private Double orbPercent;

    @Column(name = "drb_percent")
    private Double drbPercent;

    @Column(name = "trb_percent")
    private Double trbPercent;

    @Column(name = "ast_percent")
    private Double astPercent;

    @Column(name = "stl_percent")
    private Double stlPercent;

    @Column(name = "blk_percent")
    private Double blkPercent;

    @Column(name = "tov_percent")
    private Double tovPercent;

    @Column(name = "usg_percent")
    private Double usgPercent;

    private Double ows;
    private Double dws;
    private Double ws;

    @Column(name = "ws_48")
    private Double ws48;

    private Double obpm;
    private Double dbpm;
    private Double bpm;
    private Double vorp;


}
