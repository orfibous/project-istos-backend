package edu.aueb.cs.istos.giarengkinbousoulas.controller;

import edu.aueb.cs.istos.giarengkinbousoulas.configuration.Globals;
import edu.aueb.cs.istos.giarengkinbousoulas.dao.UserDaoImpl;
import edu.aueb.cs.istos.giarengkinbousoulas.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {

    public LoginServlet() {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Globals.activeUser.setEmail(email);
        Globals.activeUser.setPassword(password);

        UserDaoImpl DAO = new UserDaoImpl();

        String validateUser = null;
        try {
            validateUser = DAO.authenticateUser(Globals.activeUser);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(validateUser);
        if(validateUser.equals("SUCCESS")){
            System.out.println("SUCCESS");
            request.setAttribute("email", email);
            request.getRequestDispatcher("/html/index.jsp").forward(request, response); //TODO inform JS that a user is logged
        }
        else {
            request.setAttribute("errorMessage", validateUser);
            System.out.println("errorMessage");
            request.getRequestDispatcher("/html/login.jsp").forward(request, response);
        }
    }
}