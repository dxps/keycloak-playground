package com.example.news.controllers;

import com.example.news.services.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;


@Controller
public class AppController {

    private NewsService newsService;

    public AppController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome() {
        return "home";
    }

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String getNews(Principal principal, Model model) {
        String user = principal != null ? principal.getName() : "n/a";
        model.addAttribute("user", user);
        model.addAttribute("news", newsService.getNews());
        return "news";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getAdmin(Principal principal, Model model) {
        String user = principal != null ? principal.getName() : "n/a";
        model.addAttribute("user", user);
        return "admin";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String handleLogout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/";
    }

    @RequestMapping(value = "/access-denied", method = RequestMethod.GET)
    public String handleAccessDenied(HttpServletRequest request) throws ServletException {
        return "access-denied";
    }

}
