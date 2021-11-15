<%-- 
    Document   : index
    Created on : Nov. 13, 2021, 1:45:57 p.m.
    Author     : camilabarbosa
--%>



<%@page import="data.model.Team"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        
        <form action="HockeyLeagueServlet" method="GET">
            <img class = "logoRockey" src="assets/rockey.jpg" alt="Rockey"></br></br>
            
            <label for="teams">Team:</label>
            <select name="teams" id="teams">
                 <c:forEach var = "team" items= "${teamList}">
                          <option value=${team.teamID}> ${team.teamName}</option>
                 </c:forEach>
            </select>
            
            <br/><br/><input type="submit"value="View Team"/>
        </form>
        
      

    </body>
</html>
