package com.nazarbello.demo.dto;

public class PlayerSeasonDto {
    private final String player;
    private final String pos;
    private final String tm;
    private final int g;
    private final double mp;
    private final int pts;
    private final int trb;
    private final int ast;
    private final int stl;
    private final int blk;
    private final double fgPercent;
    private final double x3pPercent;


    public PlayerSeasonDto(
            String player,
            String pos,
            String tm,
            int g,
            double mp,
            int pts,
            int trb,
            int ast,
            int stl,
            int blk,
            double fgPercent,
            double x3pPercent
    ) {
        this.player      = player;
        this.pos         = pos;
        this.tm          = tm;
        this.g           = g;
        this.mp          = mp;
        this.pts         = pts;
        this.trb         = trb;
        this.ast         = ast;
        this.stl         = stl;
        this.blk         = blk;
        this.fgPercent   = fgPercent;
        this.x3pPercent  = x3pPercent;
    }

    public String getPlayer() {
        return player;
    }

    public String getPos() {
        return pos;
    }

    public String getTm() {
        return tm;
    }

    public int getG() {
        return g;
    }

    public double getMp() {
        return mp;
    }

    public int getPts() {
        return pts;
    }

    public int getTrb() {
        return trb;
    }

    public int getAst() {
        return ast;
    }

    public int getStl() {
        return stl;
    }

    public int getBlk() {
        return blk;
    }

    public double getFgPercent() {
        return fgPercent;
    }

    public double getX3pPercent() {
        return x3pPercent;
    }


    // getters only...
}