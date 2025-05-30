package com.nazarbello.demo.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "player_season_totals")
@IdClass(PlayerSeasonTotalsKey.class)
public class PlayerSeasonTotal {

    @Id
    @Column(name = "player_id", nullable = false)
    private Integer playerId;

    @Id
    @Column(name = "season", nullable = false)
    private Integer season;

    @Column(name = "seas_id")
    private Integer seasId;

    @Column(nullable = false)
    private String player;

    @Column(name = "birth_year")
    private Integer birthYear;

    private String pos;
    private Integer age;
    private Integer experience;
    private String lg;
    private String tm;
    private Integer g;
    private Integer gs;
    private Double mp;
    private Integer fg;
    private Integer fga;
    @Column(name = "fg_percent")
    private Double fgPercent;
    private Integer x3p;
    private Integer x3pa;
    @Column(name = "x3p_percent")
    private Double x3pPercent;
    private Integer x2p;
    private Integer x2pa;
    @Column(name = "x2p_percent")
    private Double x2pPercent;
    @Column(name = "e_fg_percent")
    private Double eFgPercent;
    private Integer ft;
    private Integer fta;
    @Column(name = "ft_percent")
    private Double ftPercent;
    private Integer orb;
    private Integer drb;
    private Integer trb;
    private Integer ast;
    private Integer stl;
    private Integer blk;
    private Integer tov;
    private Integer pf;
    private Integer pts;

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Integer getSeasId() {
        return seasId;
    }

    public void setSeasId(Integer seasId) {
        this.seasId = seasId;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getLg() {
        return lg;
    }

    public void setLg(String lg) {
        this.lg = lg;
    }

    public String getTm() {
        return tm;
    }

    public void setTm(String tm) {
        this.tm = tm;
    }

    public Integer getG() {
        return g;
    }

    public void setG(Integer g) {
        this.g = g;
    }

    public Integer getGs() {
        return gs;
    }

    public void setGs(Integer gs) {
        this.gs = gs;
    }

    public Double getMp() {
        return mp;
    }

    public void setMp(Double mp) {
        this.mp = mp;
    }

    public Integer getFg() {
        return fg;
    }

    public void setFg(Integer fg) {
        this.fg = fg;
    }

    public Integer getFga() {
        return fga;
    }

    public void setFga(Integer fga) {
        this.fga = fga;
    }

    public Double getFgPercent() {
        return fgPercent;
    }

    public void setFgPercent(Double fgPercent) {
        this.fgPercent = fgPercent;
    }

    public Integer getX3p() {
        return x3p;
    }

    public void setX3p(Integer x3p) {
        this.x3p = x3p;
    }

    public Integer getX3pa() {
        return x3pa;
    }

    public void setX3pa(Integer x3pa) {
        this.x3pa = x3pa;
    }

    public Double getX3pPercent() {
        return x3pPercent;
    }

    public void setX3pPercent(Double x3pPercent) {
        this.x3pPercent = x3pPercent;
    }

    public Integer getX2p() {
        return x2p;
    }

    public void setX2p(Integer x2p) {
        this.x2p = x2p;
    }

    public Integer getX2pa() {
        return x2pa;
    }

    public void setX2pa(Integer x2pa) {
        this.x2pa = x2pa;
    }

    public Double getX2pPercent() {
        return x2pPercent;
    }

    public void setX2pPercent(Double x2pPercent) {
        this.x2pPercent = x2pPercent;
    }

    public Double geteFgPercent() {
        return eFgPercent;
    }

    public void seteFgPercent(Double eFgPercent) {
        this.eFgPercent = eFgPercent;
    }

    public Integer getFt() {
        return ft;
    }

    public void setFt(Integer ft) {
        this.ft = ft;
    }

    public Integer getFta() {
        return fta;
    }

    public void setFta(Integer fta) {
        this.fta = fta;
    }

    public Double getFtPercent() {
        return ftPercent;
    }

    public void setFtPercent(Double ftPercent) {
        this.ftPercent = ftPercent;
    }

    public Integer getOrb() {
        return orb;
    }

    public void setOrb(Integer orb) {
        this.orb = orb;
    }

    public Integer getDrb() {
        return drb;
    }

    public void setDrb(Integer drb) {
        this.drb = drb;
    }

    public Integer getTrb() {
        return trb;
    }

    public void setTrb(Integer trb) {
        this.trb = trb;
    }

    public Integer getAst() {
        return ast;
    }

    public void setAst(Integer ast) {
        this.ast = ast;
    }

    public Integer getStl() {
        return stl;
    }

    public void setStl(Integer stl) {
        this.stl = stl;
    }

    public Integer getBlk() {
        return blk;
    }

    public void setBlk(Integer blk) {
        this.blk = blk;
    }

    public Integer getTov() {
        return tov;
    }

    public void setTov(Integer tov) {
        this.tov = tov;
    }

    public Integer getPf() {
        return pf;
    }

    public void setPf(Integer pf) {
        this.pf = pf;
    }

    public Integer getPts() {
        return pts;
    }

    public void setPts(Integer pts) {
        this.pts = pts;
    }
}