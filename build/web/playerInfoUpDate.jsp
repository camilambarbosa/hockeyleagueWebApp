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
        
        <h2>Edit Player </h2>
        
        <form action="UpDatePlayerServlet">
                 <input type="hidden" name="playerId" value ="${player.playerId}" />
            
                <label for="name">Name</label>
                <input type="text" id="name" name="name" value ="${player.playerName}"><br><br>
                
                <label for="address">Address</label>
                <input type="text" id="address" name="address" value="${player.playerAddress}" ><br><br>
                
                <label for="role"> Team </label> 

                <select name="teams" id="teams">
                    
                    <c:forEach var = "team" items= "${teamList}">
                        <c:choose>
                            <c:when test="${player.teamID== team.teamID}">
                                <option value=${team.teamID} selected> ${team.teamName} </option>
                            </c:when>
                            <c:otherwise>
                                <option value=${team.teamID}> ${team.teamName}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach> 
                                    
                </select> <br><br>
                
                 <label for="role"> Role </label> 

                <select name="role" id="role">
                    
                    <c:forEach var = "role" items= "${roleList}">
                        <c:choose>
                            <c:when test="${role == player.playerRole}">
                                <option value=${role} selected> ${role} </option>
                            </c:when>
                            <c:otherwise>
                                <option value=${role}> ${role}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach> 
                                
                </select> <br><br>  
                
                <label for="active">Active</label>
                <c:if test="${player.playerActiveStatus}">
                     <input type="checkbox" id="active" name="status" value="true" checked ></br> </br>  
                </c:if>
                      
                 <c:if test="${player.playerActiveStatus == false}">
                     <input type="checkbox" id="active" name="status" value="true"></br> </br>  
                </c:if>

                <input type="submit" value="Save"/>
                 
                 <a href="HockeyLeagueServlet?teams=${player.teamID}" class="linkButton">Cancel</a> 
                  
                  
      </form> 
        
         
    </body>
</html>
