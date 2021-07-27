package com.uni.ipldashboard.controller;

import com.uni.ipldashboard.model.Team;
import com.uni.ipldashboard.service.AppService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
}
