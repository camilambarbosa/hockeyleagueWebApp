package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import data.DBManager;
import data.model.Player;
import data.model.Team;
import data.repository.PlayerRepository;
import data.repository.TeamRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author camilabarbosa
 */
@WebServlet(urlPatterns = {"/HockeyLeagueServlet"})
public class HockeyLeagueServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         Integer abc = Integer.parseInt(request.getParameter("teams"));
         
        TeamRepository tr = new TeamRepository();
        Team team = tr.findByTeamId(abc);
        request.setAttribute("team", team);
        
       
        PlayerRepository pr= new PlayerRepository();
        ArrayList<Player> playerList =  pr.findPlayerByTeamId(abc);
       
        request.setAttribute("playerList", playerList);
        RequestDispatcher dispacher = request.getRequestDispatcher("playerList.jsp");
        dispacher.forward(request, response);
        
        

    }
}

    
    
    


