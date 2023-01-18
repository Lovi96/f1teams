package com.bredextest.f1teams.rest;

import com.bredextest.f1teams.auth.AuthenticationBean;
import com.bredextest.f1teams.dto.TeamDTO;
import com.bredextest.f1teams.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TeamsRestController {

    private final TeamService teamService;

    public TeamsRestController(TeamService teamService) {
        this.teamService = teamService;
    }


    @GetMapping(path = "/basicauth")
    public AuthenticationBean basicauth() {
        return new AuthenticationBean("You are authenticated");
    }

    @GetMapping("/teams")
    public List<TeamDTO> getAllTeams() {
        return teamService.findAll();
    }

    @GetMapping("/teams/{id}")
    public TeamDTO getTeamById(@PathVariable Long id) {
        return teamService.findById(id);
    }

    @PostMapping("/teams")
    public TeamDTO createTeam(@RequestBody TeamDTO team) {
        return teamService.save(team);
    }

    @PutMapping("/teams/{id}")
    public ResponseEntity<TeamDTO> updateTeam(@PathVariable Long id, @RequestBody TeamDTO teamDetails) {
        return ResponseEntity.ok(teamService.update(id,teamDetails));
    }

    @DeleteMapping("/teams/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTeam(@PathVariable Long id) {
        return ResponseEntity.ok(teamService.delete(id));
    }

}
