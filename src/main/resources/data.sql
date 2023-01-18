CREATE TABLE PUBLIC.TEAM (
                               id INT NOT NULL,
                               name VARCHAR(50) NOT NULL,
                               founding_year number NULL,
                               championship_wins number null,
                               paid_membership boolean NOT NULL
);

create sequence hibernate_sequence start with 10 increment by 1;

insert into PUBLIC.TEAM values (1,'Ferrari',1950,20,true);
insert into PUBLIC.TEAM values (2,'McLaren',1960,5,true);
insert into PUBLIC.TEAM values (3,'Mercedes',1970,10,true);
insert into PUBLIC.TEAM values (4,'Force-India',2009,0,true);
insert into PUBLIC.TEAM values (5,'Jordan',1996,0,false);
insert into PUBLIC.TEAM values (6,'Minardi',1980,0,false);
insert into PUBLIC.TEAM values (7,'Sauber',1996,0,true);
insert into PUBLIC.TEAM values (8,'Red Bull',2005,10,true);
insert into PUBLIC.TEAM values (9,'Renault',2002,4,true);