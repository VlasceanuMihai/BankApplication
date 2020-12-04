package com.controllers;

import com.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Locale;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 12/3/2020
 */

@Controller
public class HomeController {

    private HomeService homeService;

    @Autowired
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping(value = "/homePage")
    public String homePage(Locale locale, Model model) throws UnknownHostException {
        System.out.println("Home Page Requested, locale = " + locale);

        model.addAttribute("serverTime", this.homeService.getDate(locale));
        model.addAttribute("ipAddress", InetAddress.getLocalHost());
        return "homePage";
    }

    @GetMapping(value = "/adminPanel")
    public String adminPanel(Model model){
        return "adminPanel";
    }

    @GetMapping(value = "/clientPanel")
    public String clientPanel(Model model){
        return "clientPanel";
    }
}
