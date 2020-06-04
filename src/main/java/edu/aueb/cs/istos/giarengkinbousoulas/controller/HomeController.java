package edu.aueb.cs.istos.giarengkinbousoulas.controller;

import edu.aueb.cs.istos.giarengkinbousoulas.dao.UserDAO;
import edu.aueb.cs.istos.giarengkinbousoulas.dao.UserDaoImpl;
import edu.aueb.cs.istos.giarengkinbousoulas.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {
    @RequestMapping("/")
    public ModelAndView login(ModelAndView model){
        model.setViewName("login");
        return model;
    }

    @RequestMapping("/index")
    public ModelAndView home(ModelAndView model){
        model.setViewName("index");
        return model;
    }

    @RequestMapping("/contact")
    public ModelAndView contact(ModelAndView model){
        model.setViewName("contact");
        return model;
    }
    @RequestMapping("/account")
    public ModelAndView account(ModelAndView model){
        model.setViewName("account");
        return model;
    }

    @Autowired
    private UserDaoImpl userDAO;

    /*@RequestMapping(value = "/fetch")
    public ModelAndView listUser(ModelAndView model) throws IOException {

        List<User> usersList = userDAO.usersList();
        model.addObject("usersList", usersList);
        model.setViewName("fetch");
        return model;
    }*/
}