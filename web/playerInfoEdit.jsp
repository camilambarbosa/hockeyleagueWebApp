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
        
        <h2>Edit Player Mathew</h2>
        
        <form action="/action_page.php">
                <label for="name">Name</label>
                <input type="text" id="name" name="name" value="Mathew"><br><br>
                
                <label for="address">Address</label>
                <input type="text" id="address" name="address" value="Brasil"><br><br>
                
                <label for="role"> Team </label> 

                <select name="teams" id="teams">
                    <c:forEach var = "team" items= "${teamList}">
                             <option value=${team.teamID}> ${team.teamName}</option>
                    </c:forEach> 
                </select> <br><br>
                
                 <label for="role"> Role </label> 

                <select name="teams" id="teams">

                    <option value= "Foward"> Foward</option>
                    <option value= "Defence" selected> Defence</option>
                    <option value= "Gollie"> Gollie</option>

                </select> <br><br>   
                
                <label for="active">Active</label>
                <input type="checkbox" id="active" name="active" value="Active" checked ></br> </br>             

                
                <input type="submit" value="Save"/>
                 <a href="playerList.jsp" class="linkButton">Cancel</a>      
                  
                  
      </form> 
        
         
    </body>
</html>
