package com.uni.ipldashboard.service;

import java.time.LocalDate;
import java.util.List;

import com.uni.ipldashboard.model.Match;
import com.uni.ipldashboard.model.Team;
import com.uni.ipldashboard.repository.MatchRepository;
import com.uni.ipldashboard.repository.TeamRepository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    TeamRepository teamRepository;
    MatchRepository matchRepository;

    public AppService(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    public Team getTeam(String teamName, int count) {

        Team team = this.teamRepository.findByTeamName(teamName);
        Pageable pageable = PageRequest.of(0, count);
        team.setMatches(matchRepository.findByTeam1OrTeam2OrderByDateDesc(teamName, teamName, pageable));
        return team;
    }

    public List<Match> getMatchesForTeam(String teamName, int year) {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year + 1, 1, 1);
        return matchRepository.getMatchesByNameandDate(teamName, startDate, endDate);

    }
    
    public Iterable<Team> getAllTeams() {
       return this.teamRepository.findAll();
    }
}