package com.nazarbello.demo.dto;

public class TeamTableDto {

    private String team;       // team abbreviation, e.g. "LAL"
    private int wins;
    private int losses;
    private double winPct;     // e.g. 0.633
    private double gamesBehind;// e.g. 3.0

    public TeamTableDto(String team, int wins, int losses, double winPct, double gamesBehind) {
        this.team         = team;
        this.wins         = wins;
        this.losses       = losses;
        this.winPct       = winPct;
        this.gamesBehind  = gamesBehind;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public double getWinPct() {
        return winPct;
    }

    public void setWinPct(double winPct) {
        this.winPct = winPct;
    }

    public double getGamesBehind() {
        return gamesBehind;
    }

    public void setGamesBehind(double gamesBehind) {
        this.gamesBehind = gamesBehind;
    }
}
