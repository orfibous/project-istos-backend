package edu.aueb.cs.istos.giarengkinbousoulas.controller;

import edu.aueb.cs.istos.giarengkinbousoulas.dao.BookmarksDaoImpl;
import edu.aueb.cs.istos.giarengkinbousoulas.dao.UserDaoImpl;
import edu.aueb.cs.istos.giarengkinbousoulas.model.Bookmarks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.sql.SQLException;
import java.util.List;


@Controller
public class HomeController {



    @RequestMapping("/")
    public ModelAndView login(ModelAndView model){
        model.setViewName("login");
        return model;
    }

    @RequestMapping("/signup")
    public ModelAndView signup(ModelAndView model){
        model.setViewName("signup");
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

    @RequestMapping(value = "/getmyBookmarks", method = RequestMethod.POST)
    public @ResponseBody List<String> add(HttpServletRequest request, HttpServletResponse response, @RequestParam int userID) throws SQLException {
        BookmarksDaoImpl database = new BookmarksDaoImpl();
        Bookmarks bookmarks = new Bookmarks();
        bookmarks.setMyBookmarks(database.fillBookmarksList(userID));
        System.out.println("Get Bookmarks for " + userID);
        return bookmarks.getMyBookmarks();
    }

//    @RequestMapping("/account")
//    public ModelAndView account(ModelAndView model){
//        LoginServlet loginServlet = new LoginServlet();
//        String name = loginServlet.doPost();
//        model.setViewName("account");
//        return model;
//    }

//    @Autowired
//    private UserDaoImpl userDAO;

}