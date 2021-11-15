/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.repository;

import data.DBManager;
import data.model.Team;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author camilabarbosa
 */
public class TeamRepository {
    public ArrayList<Team> findTeams(){
        ArrayList<Team> teamsList = new ArrayList <Team>();
        DBManager dbm = new DBManager();
        try {
       
            ResultSet rs = dbm.query("SELECT * FROM teams;");
            while( rs.next() ) {
                Team team= new Team();
                team.setTeamID(rs.getInt("teamID"));
                team.setTeamName(rs.getNString("teamName"));
                
                teamsList.add(team);
            }

        } catch(Exception e){
             System.out.println("Error getting items: " + e );
        }
        return teamsList;
        
        
    }
    
    
    public Team findByTeamId(int teamID){
        Team team = null;
        DBManager dbm = new DBManager();
        try {
       
            ResultSet rs = dbm.query("SELECT * FROM teams WHERE teamID = " + teamID);
            while( rs.next() ) {
                team= new Team();
                team.setTeamID(rs.getInt("teamID"));
                team.setTeamName(rs.getNString("teamName"));
  
            }

        } catch(Exception e){
             System.out.println("Error getting items: " + e );
        }
        return team;
        
        
    }
    
    
    
    
    
}
