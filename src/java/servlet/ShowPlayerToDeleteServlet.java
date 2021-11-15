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
@WebServlet(name = "ShowPlayerToDeleteServlet", urlPatterns = {"/ShowPlayerToDeleteServlet"})
public class ShowPlayerToDeleteServlet extends HttpServlet {

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
        Integer playerId = Integer.parseInt(request.getParameter("playerId"));
       
        
        PlayerRepository pr= new PlayerRepository();
        Player player = pr.findByPlayerId(playerId);
        
        request.setAttribute("player", player);
        
        request.setAttribute("teams", abc);
        RequestDispatcher dispacher = request.getRequestDispatcher("playerInfoDelete.jsp");
        dispacher.forward(request, response);

    }
    
}