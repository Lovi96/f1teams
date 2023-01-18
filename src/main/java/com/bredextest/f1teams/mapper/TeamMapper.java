package com.bredextest.f1teams.mapper;

import com.bredextest.f1teams.dto.TeamDTO;
import com.bredextest.f1teams.entity.Team;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeamMapper {

    private final ModelMapper modelMapper;

    public TeamMapper(){
        modelMapper = new ModelMapper();
    }
    public TeamDTO convertToDto(Team team) {

        return modelMapper.map(team, TeamDTO.class);
    }
    public List<TeamDTO> convertToDTOList(List<Team> teams){
        List<TeamDTO> dtoList = new ArrayList<>();
        for(Team team: teams){
            dtoList.add(convertToDto(team));
        }
        return dtoList;
    }

    public List<Team> convertToEntityList(List<TeamDTO> teams){
        List<Team> entityList = new ArrayList<>();
        for(TeamDTO team: teams){
            entityList.add(convertToEntity(team));
        }
        return entityList;
    }

    public Team convertToEntity(TeamDTO teamDTO) {

        return modelMapper.map(teamDTO, Team.class);
    }

}
