/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  camilabarbosa
 * Created: Nov. 13, 2021
 */

CREATE TABLE teams (
    teamID int NOT NULL,
    teamname varchar(100) NOT NULL,
    PRIMARY KEY (	teamID)
);

CREATE TABLE players(
    playerID int NOT NULL,
    playerName varchar(100) NOT NULL,
    teamID int NOT NULL,
    playerRole varchar(100),
    playerActiveStatus varchar(1),
   PRIMARY KEY (playerID),
    CONSTRAINT FK_teams_players FOREIGN KEY (teamID)
    REFERENCES teams(teamID)
);


INSERT INTO teams(teamID, teamName)
VALUES (1, ‘RED’);

INSERT INTO teams(teamID, teamName)
VALUES (2, ‘Blue’);

INSERT INTO teams(teamID, teamName)
VALUES (3, ‘Green’);

INSERT INTO teams(teamID, teamName)
VALUES (4, ‘Yellow


