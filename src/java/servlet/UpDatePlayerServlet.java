/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import data.model.Player;
import data.repository.PlayerRepository;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "UpDatePlayerServlet", urlPatterns = {"/UpDatePlayerServlet"})
public class UpDatePlayerServlet extends HttpServlet {

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

        Integer playerId = Integer.parseInt(request.getParameter("playerId"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        Integer abc = Integer.parseInt(request.getParameter("teams"));
        String role = request.getParameter("role");
        Boolean status = Boolean.parseBoolean(request.getParameter("status"));
        

        
        Player player = new Player();
        player.setPlayerId(playerId);
        player.setPlayerName(name);
        player.setPlayerAddress(address);
        player.setPlayerRole(role);
        player.setPlayerActiveStatus(status);
        player.setTeamID(abc);
     
         
        PlayerRepository pr= new PlayerRepository();
        pr.updatePlayer(player);
        
        request.setAttribute("teams", abc);
        RequestDispatcher dispacher = request.getRequestDispatcher("HockeyLeagueServlet");
        dispacher.forward(request, response);

    }

}
