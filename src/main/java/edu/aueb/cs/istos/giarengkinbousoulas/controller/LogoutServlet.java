package edu.aueb.cs.istos.giarengkinbousoulas.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null){
            session.invalidate();
            request.setAttribute("errorMessage", "You have logged out successfully!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/html/login.jsp");
            requestDispatcher.forward(request, response);
            System.out.println("Logged Out!");
        }
    }
}
