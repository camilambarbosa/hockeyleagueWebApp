/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.model;

/**
 *
 * @author camilabarbosa
 */
public class Player {
    
    
    private int playerId;
    private String playerName;
    private String playerAddress;
    private int teamID;
    private String playerRole;
    private Boolean playerActiveStatus;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerID) {
        this.playerId = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerAddress() {
        return playerAddress;
    }

    public void setPlayerAddress(String playerAddress) {
        this.playerAddress = playerAddress;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public String getPlayerRole() {
        return playerRole;
    }

    public void setPlayerRole(String playerRole) {
        this.playerRole = playerRole;
    }

    public Boolean getPlayerActiveStatus() {
        return playerActiveStatus;
    }

    public void setPlayerActiveStatus(Boolean playerActivrStatus) {
        this.playerActiveStatus = playerActivrStatus;
    }
    
    
}
