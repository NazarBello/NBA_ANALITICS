package com.nazarbello.demo.repository;

import com.nazarbello.demo.model.TeamSummaries;
import com.nazarbello.demo.model.TeamSummariesKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeamSummariesRepository extends JpaRepository<TeamSummaries, TeamSummariesKey> {

    List<TeamSummaries> findByAbbreviation(String abbreviation);

    Optional<TeamSummaries> findByAbbreviationAndSeason(String abbreviation, Integer season);

    List<TeamSummaries> findBySeason(Integer season);

}
