package com.nazarbello.demo.controller;

import com.nazarbello.demo.dto.PlayerSeasonDto;
import com.nazarbello.demo.model.PlayerCareerStats;
import com.nazarbello.demo.model.PlayerSeasonTotal;
import com.nazarbello.demo.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    /**
     * GET /api/players?search={query}
     * If search is omitted, returns all players (by searching empty string).
     */
    @GetMapping
    public List<PlayerCareerStats> listPlayers(@RequestParam(name = "search", required = false) String query) {
        if (query == null || query.isBlank()) {
            // this will return everyone since LIKE '%%' matches all
            return playerService.searchPlayers("");
        }
        return playerService.searchPlayers(query);
    }

    /**
     * GET /api/players/{playerId}/career-stats
     */
    @GetMapping("/{playerId}/career-stats")
    public ResponseEntity<PlayerCareerStats> getCareerStats(@PathVariable Integer playerId) {
        return playerService.getCareerStats(playerId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



    /**
     * GET /api/players/{playerId}/seasons/{season}
     */
    @GetMapping("/{playerId}/seasons/{season}")
    public ResponseEntity<PlayerSeasonTotal> getSeasonStats(
            @PathVariable Integer playerId,
            @PathVariable Integer season
    ) {
        return playerService.getSeasonStats(playerId, season)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * GET /api/players/team/{tm}
     */
    @GetMapping("/team/{tm}")
    public List<PlayerCareerStats> getByTeam(@PathVariable("tm") String teamAbbreviation) {
        return playerService.getPlayersByTeam(teamAbbreviation);
    }

    /**
     * GET /api/players/position/{pos}
     */
    @GetMapping("/position/{pos}")
    public List<PlayerCareerStats> getByPosition(@PathVariable("pos") String position) {
        return playerService.getPlayersByPosition(position);
    }

    @GetMapping("/team/{tm}/season/{season}")
    public List<PlayerCareerStats> getByTeamAndSeason(
            @PathVariable("tm") String teamAbbreviation,
            @PathVariable("season") Integer season
    ) {
        return playerService.getPlayersByTeamAndSeason(teamAbbreviation, season);
    }


    @GetMapping("/team/{tm}/season/{season}/stats")
    public List<PlayerSeasonDto> getSeasonStatsByTeamAndYear(
            @PathVariable("tm") String tm,
            @PathVariable Integer season
    ) {
        return playerService
                .getSeasonStatsByTeamAndYear(tm, season)
                .stream()
                .map(playerService::toDto)
                .collect(Collectors.toList());
    }
}
