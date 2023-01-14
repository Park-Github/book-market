package com.naver.idealproduction.bookmarket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String getHome(Locale locale, Model model) {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String time = dateFormat.format(new Date());

        logger.info("Welcome home! The client locale is {}.", locale);
        model.addAttribute("serverTime", time);
        return "home";
    }

}