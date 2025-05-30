package com.nazarbello.demo.repository;

import com.nazarbello.demo.model.PlayerCareerStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerCareerStatsRepository extends JpaRepository<PlayerCareerStats, Integer> {
    
    Optional<PlayerCareerStats> findByPlayerId(Integer playerId);

    List<PlayerCareerStats> findByPlayerNameContainingIgnoreCase(String query);
}
