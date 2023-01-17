package com.naver.idealproduction.bookmarket.Controller;

import com.naver.idealproduction.bookmarket.Service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final HomeService homeService;

    @Autowired
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/")
    public String handling_serverT(Model model) {
        model.addAttribute("serverTime", homeService.getServerT());
        return "home";
    }

}
