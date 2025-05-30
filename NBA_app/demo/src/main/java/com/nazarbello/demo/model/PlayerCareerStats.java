package com.nazarbello.demo.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import java.math.BigDecimal;

/**
 * Read-only entity mapped to the player_career_stats view.
 */
@NoArgsConstructor
@Entity
@Immutable
@Table(name = "player_career_stats")
public class PlayerCareerStats {

    @Id
    @Column(name = "player_id", nullable = false)
    private Integer playerId;

    @Column(name = "player_name", nullable = false)
    private String playerName;

    @Column(name = "total_games")
    private Integer totalGames;

    @Column(name = "total_points")
    private Integer totalPoints;

    @Column(name = "total_rebounds")
    private Integer totalRebounds;

    @Column(name = "total_assists")
    private Integer totalAssists;

    @Column(name = "total_steals")
    private Integer totalSteals;

    @Column(name = "total_blocks")
    private Integer totalBlocks;

    @Column(name = "fg_percent")
    private BigDecimal fgPercent;

    @Column(name = "x3p_percent")
    private BigDecimal x3pPercent;

    @Column(name = "ts_percent")
    private BigDecimal tsPercent;


    public Integer getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Integer getTotalGames() {
        return totalGames;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public Integer getTotalRebounds() {
        return totalRebounds;
    }

    public Integer getTotalAssists() {
        return totalAssists;
    }

    public Integer getTotalSteals() {
        return totalSteals;
    }

    public Integer getTotalBlocks() {
        return totalBlocks;
    }

    public BigDecimal getFgPercent() {
        return fgPercent;
    }

    public BigDecimal getX3pPercent() {
        return x3pPercent;
    }

    public BigDecimal getTsPercent() {
        return tsPercent;
    }
}