// src/main/java/com/nazarbello/demo/service/PlayerService.java
package com.nazarbello.demo.service;

import com.nazarbello.demo.dto.PlayerSeasonDto;
import com.nazarbello.demo.model.PlayerCareerStats;
import com.nazarbello.demo.model.PlayerSeasonStats;
import com.nazarbello.demo.model.PlayerSeasonTotal;
import com.nazarbello.demo.repository.PlayerCareerStatsRepository;
import com.nazarbello.demo.repository.PlayerSeasonTotalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service layer for player-centric operations.
 */
@Service
public class PlayerService {

    private final PlayerCareerStatsRepository careerStatsRepo;
    private final PlayerSeasonTotalRepository seasonRepo;

    public PlayerService(PlayerCareerStatsRepository careerStatsRepo,
                         PlayerSeasonTotalRepository seasonRepo) {
        this.careerStatsRepo = careerStatsRepo;
        this.seasonRepo = seasonRepo;
    }


    /**
     * Search players by partial name (case-insensitive).
     */
    public List<PlayerCareerStats> searchPlayers(String query) {
        return careerStatsRepo.findByPlayerNameContainingIgnoreCase(query);
    }

    /**
     * Get a single player's career aggregates.
     */
    public Optional<PlayerCareerStats> getCareerStats(Integer playerId) {
        return careerStatsRepo.findById(playerId);
    }


    /**
     * Get all season totals for a player (all seasons).
     */
    public List<PlayerSeasonTotal> getAllSeasonStats(Integer playerId) {
        return seasonRepo.findByPlayerIdOrderBySeasonDesc(playerId);
    }

    /**
     * Get a specific season total for a player.
     */
    public Optional<PlayerSeasonTotal> getSeasonStats(Integer playerId, Integer season) {
        return seasonRepo.findByPlayerIdAndSeason(playerId, season);
    }


    public List<PlayerCareerStats> getPlayersByTeam(String teamAbbreviation) {
        List<Integer> ids = seasonRepo.findByTm(teamAbbreviation).stream()
                .map(PlayerSeasonTotal::getPlayerId)
                .distinct()
                .collect(Collectors.toList());
        return careerStatsRepo.findAllById(ids);
    }

    /**
     * List all players by position (distinct career stats) for a given position.
     */
    public List<PlayerCareerStats> getPlayersByPosition(String position) {
        List<Integer> ids = seasonRepo.findByPos(position).stream()
                .map(PlayerSeasonTotal::getPlayerId)
                .distinct()
                .collect(Collectors.toList());
        return careerStatsRepo.findAllById(ids);
    }

    public List<PlayerCareerStats> getPlayersByTeamAndSeason(String team, Integer season) {
        var ids = seasonRepo
                .findByTmAndSeason(team, season)      // only that season
                .stream()
                .map(PlayerSeasonTotal::getPlayerId)
                .distinct()
                .toList();
        return careerStatsRepo.findAllById(ids);
    }

    public List<PlayerSeasonTotal> getSeasonStatsByTeamAndYear(String team, Integer season) {
        return seasonRepo.findByTmAndSeason(team, season);
    }
    public PlayerSeasonDto toDto(PlayerSeasonTotal e) {
        return new PlayerSeasonDto(
                e.getPlayer(),
                e.getPos(),
                e.getTm(),
                e.getG(),
                e.getMp(),
                e.getPts(),
                e.getTrb(),
                e.getAst(),
                e.getStl(),
                e.getBlk(),
                e.getFgPercent()   != null ? e.getFgPercent()   : 0.0,
                e.getX3pPercent()  != null ? e.getX3pPercent()  : 0.0

        );
    }


}
