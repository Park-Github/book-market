package com.naver.idealproduction.bookmarket.controller;

import com.naver.idealproduction.bookmarket.domain.Member;
import com.naver.idealproduction.bookmarket.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        boolean valid = !service.hasDuplicateID(id);
        return String.valueOf(valid);
    }

    @PostMapping("/register")
    public String submitRegisterForm(@ModelAttribute Member member) {
        service.register(member);
        return "redirect:/";
    }

}
