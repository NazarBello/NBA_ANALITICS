// src/main/java/com/nazarbello/demo/service/TeamService.java
package com.nazarbello.demo.service;

import com.nazarbello.demo.dto.TeamTableDto;
import com.nazarbello.demo.model.TeamSummaries;
import com.nazarbello.demo.repository.TeamSummariesRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private final TeamSummariesRepository repo;

    public TeamService(TeamSummariesRepository repo) {
        this.repo = repo;
    }

    /**
     * Return the standings for a given season, sorted by wins desc.
     */
    public List<TeamTableDto> getStandings(Integer season) {
        // 1) load raw data
        List<TeamSummaries> rows = repo.findBySeason(season);

        // 2) sort by wins descending
        rows.sort(Comparator.comparing(TeamSummaries::getW).reversed());

        // 3) leader’s record to compute GB
        int leaderWins   = rows.get(0).getW();
        int leaderLosses= rows.get(0).getL();

        // 4) map to DTO
        return rows.stream()
                .map(r -> {
                    int w = r.getW(), l = r.getL();
                    double pct = Math.round((1000.0 * w/(w + l))) / 1000.0;
                    double gb  = Math.round(
                            10.0 * ((leaderWins - w) + (l - leaderLosses)) / 2
                    ) / 10.0;
                    return new TeamTableDto(
                            r.getAbbreviation(),
                            w, l,
                            pct,
                            gb
                    );
                })
                .collect(Collectors.toList());
    }
}
