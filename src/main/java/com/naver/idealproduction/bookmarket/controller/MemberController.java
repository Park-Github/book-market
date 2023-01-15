package com.naver.idealproduction.bookmarket.controller;

import com.naver.idealproduction.bookmarket.domain.Member;
import com.naver.idealproduction.bookmarket.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService service;

    @Autowired
    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping("/register")
    public String getRegisterForm() {
        return "member-register";
    }

    @GetMapping("/register/validate-id")
    @ResponseBody
    public String validateID(@RequestParam("id") String id) {
        boolean valid = !service.exists(id);
        return String.valueOf(valid);
    }

    @GetMapping("/register/query-id")
    @ResponseBody
    public String queryID(@RequestParam("id") String id) {
        boolean valid = service.exists(id);
        return String.valueOf(valid);
    }

    @GetMapping("/register/query-pwd")
    @ResponseBody
    public String queryPassword(
            @RequestParam("id") String id,
            @RequestParam("password") String password
    ) {
        boolean valid = service.matchPassword(id, password);
        return String.valueOf(valid);
    }

    @PostMapping("/register")
    public String submitRegisterForm(@ModelAttribute Member member) {
        service.register(member);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "member-login";
    }

    @PostMapping("/login")
    public String submitLoginForm(
            @RequestParam("id") String id,
            @RequestParam("password") String password,
            HttpServletRequest request
    ) {
        if (!service.exists(id)) {
            throw new ErrorResponseException(HttpStatus.NOT_FOUND);
        }

        if (!service.matchPassword(id, password)) {
            throw new ErrorResponseException(HttpStatus.UNAUTHORIZED);
        }

        var session = request.getSession();
        session.setAttribute("id", id);
        session.setAttribute("authorized", true);
        session.invalidate();
        return "redirect:/";
    }

}
