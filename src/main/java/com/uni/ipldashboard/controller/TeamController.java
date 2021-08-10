package com.uni.ipldashboard.controller;

import java.util.List;

import com.uni.ipldashboard.model.Match;
import com.uni.ipldashboard.model.Team;
import com.uni.ipldashboard.service.AppService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TeamController {

    @Autowired
    AppService appService;

    public TeamController() {

    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {

        Team team = this.appService.getTeam(teamName, 4);
        return team;

    }

    @GetMapping("/team/{teamName}/matches")
    public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year) {

        return this.appService.getMatchesForTeam(teamName, year);
    }

    @GetMapping("/team")
    public Iterable<Team> getAllTeams() {
        return this.appService.getAllTeams();
    }
}
