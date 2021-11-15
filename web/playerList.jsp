<%-- 
    Document   : playerList
    Created on : Nov. 13, 2021, 11:06:56 p.m.
    Author     : camilabarbosa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="data.model.Team"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <jsp:include page = "head.jsp" />
    <body>
         <jsp:include page = "header.jsp" />
         <h2>Team ${team.teamName}</h2>
         <ul>
             
              <c:forEach var = "player" items= "${playerList}">
                  <li>
                    <span class="playerName">${player.playerName}</span>
                     
                     <a href="ShowPlayerToUpDateServlet?playerId=${player.playerId}&teams=${player.teamID}"><img class = "edition" src="assets/edit.jpeg" alt="Edit"></a>
                    <a href="ShowPlayerToDeleteServlet?playerId=${player.playerId}&teams=${player.teamID}"><img class = "edition" src="assets/delete.jpeg" alt="Delete"></a>
                </li>
              </c:forEach>
            
         </ul>  
         
         
         
         <a href="playerInfoAdd.jsp" class="linkButton">Add Player</a>
         <a href="index.jsp" class="linkButton">Cancel</a>


    </body>
</html>
