package com.bredextest.f1teams.service;

import com.bredextest.f1teams.dto.TeamDTO;

import java.util.List;
import java.util.Map;

public interface TeamService {
    public List<TeamDTO> findAll();
    public TeamDTO findById(Long id);
    public TeamDTO save(TeamDTO team);
    public TeamDTO update(Long id,TeamDTO teamDetails);
    public Map<String,Boolean> delete(Long id);
}
