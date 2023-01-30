package com.naver.idealproduction.bookmarket.controller;

import com.naver.idealproduction.bookmarket.domain.Member;
import com.naver.idealproduction.bookmarket.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService service;
    public static Member mem = null;

    @Autowired
    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping("/register")
    public String getRegisterForm(HttpServletRequest request, Model model) {
        service.supplyModelAttribute(request, model);
        return "member-register";
    }

    @PostMapping("/register")
    public String submitRegisterForm(@ModelAttribute Member member) {
        service.register(member);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String getLoginForm(HttpServletRequest request, Model model) {
        service.supplyModelAttribute(request, model);
        return "member-login";
    }

    @PostMapping("/login")
    public String submitLoginForm(@RequestParam(value = "id") String id,
                                  @RequestParam(value = "password") String password,
                                  HttpServletRequest request) {
        if (service.matchPassword(id, password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("member-id", id);
        }

        return "redirect:/";
    }

    @GetMapping("/profile")
    public String getProfileForm(HttpServletRequest request, Model model) {
        service.supplyModelAttribute(request, model);
        return "member-profile";
    }

    @PostMapping("/profile")
    public String submitProfileForm(@ModelAttribute Member member) {
        String id = member.getId();
        service.updateProfile(member);
        mem = service.getMember(id).orElse(null);
        return "redirect:/";
    }

}
