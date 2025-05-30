package com.nazarbello.demo.repository;

import com.nazarbello.demo.model.PlayerSeasonTotal;
import com.nazarbello.demo.model.PlayerSeasonTotalsKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface PlayerSeasonTotalRepository extends JpaRepository<PlayerSeasonTotal, PlayerSeasonTotalsKey> {

    List<PlayerSeasonTotal> findByPlayerId(Integer playerId);
    Optional<PlayerSeasonTotal> findByPlayerIdAndSeason(Integer playerId, Integer season);

    List <PlayerSeasonTotal> findByPlayerIdOrderBySeasonDesc(Integer playerId);

    List<PlayerSeasonTotal> findByPos(String position);

    List<PlayerSeasonTotal> findByTm(String teamAbbreviation);

    List<PlayerSeasonTotal> findByTmAndSeason(String team, Integer season);

}
