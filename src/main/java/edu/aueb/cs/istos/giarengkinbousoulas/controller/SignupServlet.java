package edu.aueb.cs.istos.giarengkinbousoulas.controller;

import edu.aueb.cs.istos.giarengkinbousoulas.dao.SignupDao;
import edu.aueb.cs.istos.giarengkinbousoulas.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignupServlet extends HttpServlet{
    public SignupServlet(){}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User registeredUser = new User();
        registeredUser.setEmail(email);
        registeredUser.setPassword(password);

        SignupDao signupDao = new SignupDao();

        String userSignedUp = signupDao.registerUser(registeredUser);
        if(userSignedUp.equals("SUCCESS")) {
            request.getRequestDispatcher("/html/login.jsp").forward(request, response);
        }
        else {
            request.setAttribute("errorMessage", userSignedUp);
            request.getRequestDispatcher("/html/signup.jsp").forward(request, response);
        }
    }
}
