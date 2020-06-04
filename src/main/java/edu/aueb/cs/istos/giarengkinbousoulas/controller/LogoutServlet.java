package edu.aueb.cs.istos.giarengkinbousoulas.controller;

import edu.aueb.cs.istos.giarengkinbousoulas.configuration.Globals;

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
            Globals.activeUser.setID(-1);
            Globals.activeUser.setPassword(null);
            Globals.activeUser.setEmail(null);
            Globals.activeUserBookmarks.setUserID(-1);
            Globals.activeUserBookmarks.setMyBookmarks(null);
            request.setAttribute("errorMessage", "You have logged out successfully!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/html/login.jsp");
            requestDispatcher.forward(request, response);
            System.out.println("Logged Out!");
        }
    }
}
