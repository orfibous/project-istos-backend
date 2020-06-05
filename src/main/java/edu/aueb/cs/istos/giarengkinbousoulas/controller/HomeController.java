//        Alexandros Giarengkin 3160025
//        Orfeas Georgios Mposoulas - Raikidis 3160111


package edu.aueb.cs.istos.giarengkinbousoulas.controller;

import edu.aueb.cs.istos.giarengkinbousoulas.configuration.Globals;
import edu.aueb.cs.istos.giarengkinbousoulas.dao.BookmarksDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;


@Controller
public class HomeController {


    //Controller to load home page
    @RequestMapping("/")
    public ModelAndView login(ModelAndView model){
        model.setViewName("login");
        return model;
    }

    //Controller to load signup page
    @RequestMapping("/signup")
    public ModelAndView signup(ModelAndView model){
        model.setViewName("signup");
        return model;
    }

    //Controller to load index / search page
    @RequestMapping("/index")
    public ModelAndView home(ModelAndView model){
        model.setViewName("index");
        return model;
    }

    //Controller to load contact page
    @RequestMapping("/contact")
    public ModelAndView contact(ModelAndView model){
        model.setViewName("contact");
        return model;
    }

    //Controller to load home page
    @RequestMapping("/account")
    public ModelAndView account(ModelAndView model){
        BookmarksDaoImpl database = new BookmarksDaoImpl();
        try {
            Globals.activeUserBookmarks.setMyBookmarks(database.fillBookmarksList(Globals.activeUserBookmarks.getUserID()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        model.addObject("myBookmarks", Globals.activeUserBookmarks.getMyBookmarks());
        model.setViewName("account");
        return model;
    }

    @RequestMapping(value = "/addBookmark", method = RequestMethod.POST)
    public @ResponseBody String addBookmark(@RequestBody String movieID){
        movieID = movieID.substring(1,movieID.length() -1);
        BookmarksDaoImpl database = new BookmarksDaoImpl();
        try {
            database.addBookmark(Globals.activeUserBookmarks.getUserID(), movieID);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return movieID;
    }


    @RequestMapping(value = "/removeBookmark", method = RequestMethod.POST)
    public @ResponseBody String removeBookmark(@RequestBody String movieID){
        movieID = movieID.substring(1,movieID.length() -1);
        BookmarksDaoImpl database = new BookmarksDaoImpl();
        try {
            database.removeBookmark(Globals.activeUserBookmarks.getUserID(), movieID);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return movieID;
    }
}