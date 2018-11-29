
package br.senac.tads.pi3b.servlet.ticket;

import br.senac.tads.pi3b.DAO.TicketDAO;
import br.senac.tads.pi3b.model.Ticket;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rbezerra
 */
@WebServlet(name = "IncluirTicketServlet", urlPatterns = {"/IncluirTicket"})
public class IncluirTicket extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        

          
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("WEB-INF/Ticket/incluirTicket.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String titulo = request.getParameter("txtTitulo");
        String descricao = request.getParameter("txtDescricao");
      
        Ticket t = new Ticket(titulo, descricao);

        
        try {
           TicketDAO.inserir(t);
        } catch (Exception e) {

        }
       
        
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(
                        "menu.jsp");
        dispatcher.forward(request, response);
        
    }
}
