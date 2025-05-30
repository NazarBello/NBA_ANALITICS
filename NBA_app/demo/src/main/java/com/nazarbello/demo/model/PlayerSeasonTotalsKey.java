package com.nazarbello.demo.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Composite primary key for PlayerSeasonTotal: playerId + season
 */
public class PlayerSeasonTotalsKey implements Serializable {
    private Integer playerId;
    private Integer season;

    public PlayerSeasonTotalsKey() {}

    public PlayerSeasonTotalsKey(Integer playerId, Integer season) {
        this.playerId = playerId;
        this.season = season;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerSeasonTotalsKey)) return false;
        PlayerSeasonTotalsKey that = (PlayerSeasonTotalsKey) o;
        return Objects.equals(playerId, that.playerId) &&
                Objects.equals(season, that.season);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, season);
    }
}
