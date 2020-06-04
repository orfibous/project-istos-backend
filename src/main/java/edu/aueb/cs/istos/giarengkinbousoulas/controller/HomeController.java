package edu.aueb.cs.istos.giarengkinbousoulas.controller;

import edu.aueb.cs.istos.giarengkinbousoulas.configuration.Globals;
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
        BookmarksDaoImpl database = new BookmarksDaoImpl();
        try {
            Globals.activeUserBookmarks.setMyBookmarks(database.fillBookmarksList(Globals.activeUserBookmarks.getUserID()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        model.addObject("myBookmarks", Globals.activeUserBookmarks.getMyBookmarks());
        System.out.println(Globals.activeUserBookmarks.getMyBookmarks().get(0));
        model.setViewName("account");
        return model;
    }

//    @RequestMapping(value = "/getmyBookmarks", method = RequestMethod.POST)
//    public @ResponseBody List<String> add(HttpServletRequest request, HttpServletResponse response) throws SQLException {
//        BookmarksDaoImpl database = new BookmarksDaoImpl();
//        Globals.activeUserBookmarks.setMyBookmarks(database.fillBookmarksList(Globals.activeUserBookmarks.getUserID()));
//        System.out.println("Get Bookmarks for " + Globals.activeUserBookmarks.getUserID());
//        return Globals.activeUserBookmarks.getMyBookmarks();
//    }
//
//    @RequestMapping("getBookmarks")
//    public List<String> getBookmarks() throws SQLException {
//        BookmarksDaoImpl database = new BookmarksDaoImpl();
//        Globals.activeUserBookmarks.setMyBookmarks(database.fillBookmarksList(Globals.activeUserBookmarks.getUserID()));
//        return Globals.activeUserBookmarks.getMyBookmarks();
//    }

}