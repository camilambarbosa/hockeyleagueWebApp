<%-- 
    Document   : playerInfo
    Created on : Nov. 13, 2021, 11:55:49 p.m.
    Author     : camilabarbosa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="data.model.Team"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import = "data.repository.TeamRepository" %>
<%@page import = "data.repository.TeamRepository" %>

<!DOCTYPE html>
<html>
    <jsp:include page = "head.jsp" />
    <body>
        <jsp:include page = "header.jsp" />
        
         <% TeamRepository tr= new TeamRepository();
          ArrayList<Team> teamList = tr.findTeams();
          session.setAttribute("teamList", tr.findTeams());
          System.out.println(">>>>teamList="+teamList.size());
          
          %>
        
        <h2>Delete Player ${player.playerName}</h2>
        
        <h3> Are you sure you want to delete this player?</h3>
        
        <form action="DeletePlayerServlet" method="GET">
            
            <input type="submit" value="Delete"/>
            <input type="hidden" value =${player.playerId} name="playerId"> 
            <input type="hidden" value =${player.teamID} name="teams"> 

            <a href="HockeyLeagueServlet?teams=${player.teamID}" class="linkButton">Cancel</a>      
 
      </form> 
        
         
    </body>
</html>
