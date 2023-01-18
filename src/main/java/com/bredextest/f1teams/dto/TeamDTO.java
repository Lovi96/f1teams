package com.bredextest.f1teams.dto;

import lombok.Data;

@Data
public class TeamDTO {
    private Long id;
    private String name;
    private Integer foundingYear;
    private Integer championshipWins;
    private boolean paidMembership;
}
