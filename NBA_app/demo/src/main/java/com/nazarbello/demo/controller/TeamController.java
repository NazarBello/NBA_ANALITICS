// src/main/java/com/nazarbello/demo/controller/TeamController.java
package com.nazarbello.demo.controller;

import com.nazarbello.demo.dto.TeamTableDto;
import com.nazarbello.demo.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/standings")
public class TeamController {

    private final TeamService svc;

    public TeamController(TeamService svc) {
        this.svc = svc;
    }

    @GetMapping("/{season}")
    public ResponseEntity<List<TeamTableDto>> getStandings(
            @PathVariable Integer season) {
        List<TeamTableDto> standings = svc.getStandings(season);
        return ResponseEntity.ok(standings);
    }
}
