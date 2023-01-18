package com.bredextest.f1teams.service;

import com.bredextest.f1teams.dto.TeamDTO;
import com.bredextest.f1teams.exception.ResourceNotFoundException;
import com.bredextest.f1teams.mapper.TeamMapper;
import com.bredextest.f1teams.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class TeamServiceImpl implements TeamService{

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public TeamServiceImpl(TeamRepository teamRepository, TeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    @Override
    public List<TeamDTO> findAll() {
        return teamMapper.convertToDTOList(teamRepository.findAll());
    }

    @Override
    public TeamDTO findById(Long id) {
        return teamMapper.convertToDto(teamRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Team not found with ID: "+id)));
    }

    @Override
    public TeamDTO save(TeamDTO team) {
        return teamMapper.convertToDto(teamRepository.save(teamMapper.convertToEntity(team)));
    }

    @Override
    public TeamDTO update(Long id, TeamDTO teamDetails) {
        TeamDTO team = findById(id);

        team.setName(teamDetails.getName());
        team.setFoundingYear(teamDetails.getFoundingYear());
        team.setChampionshipWins(teamDetails.getChampionshipWins());
        team.setPaidMembership(teamDetails.isPaidMembership());

        return save(team);
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        TeamDTO team = findById(id);
        teamRepository.delete(teamMapper.convertToEntity(team));
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
