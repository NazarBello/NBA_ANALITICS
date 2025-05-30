package com.nazarbello.demo.repository;

import com.nazarbello.demo.model.PlayerSeasonStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerSeasonStatsRepository extends JpaRepository<PlayerSeasonStats, Long> {

    // Find all seasons for a given player
    List<PlayerSeasonStats> findByPlayerIdOrderBySeasonDesc(Long playerId);

    // Find stats by player and season
    Optional<PlayerSeasonStats> findByPlayerIdAndSeason(Long playerId, Integer season);

    List<PlayerSeasonStats> findByTmAndSeason(String team, Integer season);
}
