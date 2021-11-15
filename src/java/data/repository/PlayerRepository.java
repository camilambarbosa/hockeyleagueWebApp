/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.repository;

import data.DBManager;
import data.model.Player;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author camilabarbosa
 */
public class PlayerRepository {
    public ArrayList<Player> findPlayerByTeamId(int teamId) {
        ArrayList<Player> playerList = new ArrayList <Player>();
        DBManager dbm = new DBManager();
        
        try{
            ResultSet rs= dbm.query("SELECT * FROM Players Where TeamID = " + teamId);
            while (rs.next()) {
                Player player = new Player();
                player.setPlayerId(rs.getInt("playerId"));
                player.setPlayerName(rs.getNString("playerName"));
                player.setTeamID(rs.getInt("teamId"));
                player.setPlayerRole(rs.getNString("playerRole"));
                player.setPlayerActiveStatus(rs.getString("playerActiveStatus").equals("T"));
                player.setPlayerAddress(rs.getNString("playerAddress"));
                
                playerList.add(player);
                
            }
        
        } catch(Exception e) {
            System.out.println("Error getting items: " + e );
        }
        return playerList;
    }
    
    
     public Player findByPlayerId(int playerId) {
        Player player = null;
        DBManager dbm = new DBManager();
        
        try{
            ResultSet rs= dbm.query("SELECT * FROM Players Where PlayerID = " + playerId);
            while (rs.next()) {
                player = new Player();
                player.setPlayerId(rs.getInt("playerId"));
                player.setPlayerName(rs.getNString("playerName"));
                player.setTeamID(rs.getInt("teamId"));
                player.setPlayerRole(rs.getNString("playerRole"));
                player.setPlayerActiveStatus(rs.getString("playerActiveStatus").equals("T"));
                player.setPlayerAddress(rs.getNString("playerAddress"));
               
                
            }
        
        } catch(Exception e) {
            System.out.println("Error getting items: " + e );
        }
        return player;
    }
    
    public void createPlayer (Player player) {
        DBManager dbm = new DBManager();
        
        String status = "";
        if(player.getPlayerActiveStatus() ){
            
            status = "T";
        } else {
            status = "N";
        }
            
        String createSql =" INSERT INTO Players ( playerName, TeamId, playerRole, playerActiveStatus, playerAddress)\n" +     
        "Values ('"+ player.getPlayerName() + "'," + player.getTeamID() + ",'" +  player.getPlayerRole() + "','" + status+ "','" + player.getPlayerAddress()+"')";
        System.out.println(" Aqui esta imprimindo o teste: " + createSql);
        
        dbm.update(createSql ); 
        
        
        
    }
 
    
    public void updatePlayer (Player player) {
        String status = "";
        if(player.getPlayerActiveStatus() ){
            
            status = "T";
        } else {
            status = "N";
        }
         
        String upDateSql = " UPDATE Players  SET playerName =  '"  + player.getPlayerName() + "', TeamId="+ player.getTeamID() + ",PlayerRole='" + player.getPlayerRole() + "',PlayerActiveStatus='" + status + "',PlayerAddress='" + player.getPlayerAddress() + "'";
        System.out.println("Aqui tem o upDateSql: " + upDateSql);
        
        DBManager dbm = new DBManager();
        dbm.update( upDateSql);
        
        
    }
    
    public void deletePlayer (int playerID) {
        DBManager dbm = new DBManager();
        dbm.update( " DELETE FROM  Players WHERE PlayerID = "  + playerID );
        
    }
    
}


