package edu.aueb.cs.istos.giarengkinbousoulas.controller;

import edu.aueb.cs.istos.giarengkinbousoulas.dao.UserDaoImpl;
import edu.aueb.cs.istos.giarengkinbousoulas.model.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    public LoginServlet() {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        UserDaoImpl DAO = new UserDaoImpl();

        String validateUser = DAO.authenticateUser(user);
        if(validateUser.equals("SUCCESS")){
            request.setAttribute("email", email);
            request.getRequestDispatcher("/index.jsp");
        }
        else {
            request.setAttribute("errorMessage", validateUser);
            request.getRequestDispatcher("/login.jsp");
        }
    }
}