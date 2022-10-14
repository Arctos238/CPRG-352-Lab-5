/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ca.sait.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author J. Pointer
 */
@WebServlet(name = "ShoppingListServlet", urlPatterns = {"shoppingList"})
public class ShoppingListServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String username = (String) request.getSession().getAttribute("name");
        
        if (action != null && action.equals("logout")) {
            request.getSession().invalidate();
            response.sendRedirect("shoppingList");
            return;
        }

        if (username != null) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        } else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if(action.equals("register")) {
             String username = request.getParameter("username");
             request.getSession().setAttribute("username", username);
             
             ArrayList<String> items = new ArrayList<>();
             request.getSession().setAttribute("items", items);
        } else if (action.equals("add")) {
            String item = request.getParameter("item");
            
            ArrayList<String> items = (ArrayList<String>) request.getSession().getAttribute("items");
            items.add(item);
            
            request.getSession().setAttribute("items",items);
        } else if (action.equals("delete")) {
            String itemValue = request.getParameter("item");
            
            ArrayList<String> items = (ArrayList<String>) request.getSession().getAttribute("items");
            
            items.remove(itemValue);
        }
       

        this.getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }

}
