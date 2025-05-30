// TeamSummaries.java
package com.nazarbello.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "team_summaries")
@IdClass(TeamSummariesKey.class)
public class TeamSummaries {

    @Id
    @Column(nullable = false)
    private Integer season;

    @Id
    @Column(nullable = false)
    private String abbreviation;

    @Column(name = "lg")
    private String lg;

    @Column(name = "team")
    private String team;

    private Boolean playoffs;
    private Integer age;
    private Integer w;
    private Integer l;
    private Integer pw;
    private Integer pl;
    private Double mov;
    private Double sos;
    private Double srs;

    @Column(name = "o_rtg")
    private Double oRtg;

    @Column(name = "d_rtg")
    private Double dRtg;

    @Column(name = "n_rtg")
    private Double nRtg;

    private Double pace;

    @Column(name = "f_tr")
    private Double fTr;

    @Column(name = "x3p_ar")
    private Double x3pAr;

    @Column(name = "ts_percent")
    private Double tsPercent;

    @Column(name = "e_fg_percent")
    private Double eFgPercent;

    @Column(name = "tov_percent")
    private Double tovPercent;

    @Column(name = "orb_percent")
    private Double orbPercent;

    @Column(name = "ft_fga")
    private Double ftFga;

    @Column(name = "opp_e_fg_percent")
    private Double oppEFgPercent;

    @Column(name = "opp_tov_percent")
    private Double oppTovPercent;

    @Column(name = "opp_drb_percent")
    private Double oppDrbPercent;

    @Column(name = "opp_ft_fga")
    private Double oppFtFga;

    private String arena;
    private Integer attend;

    @Column(name = "attend_g")
    private Integer attendG;

    // — standard getters & setters below —

    public Integer getSeason() { return season; }
    public void setSeason(Integer season) { this.season = season; }

    public String getAbbreviation() { return abbreviation; }
    public void setAbbreviation(String abbreviation) { this.abbreviation = abbreviation; }

    public String getLg() { return lg; }
    public void setLg(String lg) { this.lg = lg; }

    public String getTeam() { return team; }
    public void setTeam(String team) { this.team = team; }

    public Boolean getPlayoffs() { return playoffs; }
    public void setPlayoffs(Boolean playoffs) { this.playoffs = playoffs; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public Integer getW() { return w; }
    public void setW(Integer w) { this.w = w; }

    public Integer getL() { return l; }
    public void setL(Integer l) { this.l = l; }

    public Integer getPw() { return pw; }
    public void setPw(Integer pw) { this.pw = pw; }

    public Integer getPl() { return pl; }
    public void setPl(Integer pl) { this.pl = pl; }

    public Double getMov() { return mov; }
    public void setMov(Double mov) { this.mov = mov; }

    public Double getSos() { return sos; }
    public void setSos(Double sos) { this.sos = sos; }

    public Double getSrs() { return srs; }
    public void setSrs(Double srs) { this.srs = srs; }

    public Double getORtg() { return oRtg; }
    public void setORtg(Double oRtg) { this.oRtg = oRtg; }

    public Double getDRtg() { return dRtg; }
    public void setDRtg(Double dRtg) { this.dRtg = dRtg; }

    public Double getNRtg() { return nRtg; }
    public void setNRtg(Double nRtg) { this.nRtg = nRtg; }

    public Double getPace() { return pace; }
    public void setPace(Double pace) { this.pace = pace; }

    public Double getFTr() { return fTr; }
    public void setFTr(Double fTr) { this.fTr = fTr; }

    public Double getX3pAr() { return x3pAr; }
    public void setX3pAr(Double x3pAr) { this.x3pAr = x3pAr; }

    public Double getTsPercent() { return tsPercent; }
    public void setTsPercent(Double tsPercent) { this.tsPercent = tsPercent; }

    public Double geteFgPercent() { return eFgPercent; }
    public void seteFgPercent(Double eFgPercent) { this.eFgPercent = eFgPercent; }

    public Double getTovPercent() { return tovPercent; }
    public void setTovPercent(Double tovPercent) { this.tovPercent = tovPercent; }

    public Double getOrbPercent() { return orbPercent; }
    public void setOrbPercent(Double orbPercent) { this.orbPercent = orbPercent; }

    public Double getFtFga() { return ftFga; }
    public void setFtFga(Double ftFga) { this.ftFga = ftFga; }

    public Double getOppEFgPercent() { return oppEFgPercent; }
    public void setOppEFgPercent(Double oppEFgPercent) { this.oppEFgPercent = oppEFgPercent; }

    public Double getOppTovPercent() { return oppTovPercent; }
    public void setOppTovPercent(Double oppTovPercent) { this.oppTovPercent = oppTovPercent; }

    public Double getOppDrbPercent() { return oppDrbPercent; }
    public void setOppDrbPercent(Double oppDrbPercent) { this.oppDrbPercent = oppDrbPercent; }

    public Double getOppFtFga() { return oppFtFga; }
    public void setOppFtFga(Double oppFtFga) { this.oppFtFga = oppFtFga; }

    public String getArena() { return arena; }
    public void setArena(String arena) { this.arena = arena; }

    public Integer getAttend() { return attend; }
    public void setAttend(Integer attend) { this.attend = attend; }

    public Integer getAttendG() { return attendG; }
    public void setAttendG(Integer attendG) { this.attendG = attendG; }
}
