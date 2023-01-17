package com.naver.idealproduction.bookmarket.Controller;

import com.naver.idealproduction.bookmarket.Domain.Member;
import com.naver.idealproduction.bookmarket.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member/register")
public class RegisterController {

    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping
    public String nav_register() {
        return "member-register";
    }

    @GetMapping("/validate-id")
    @ResponseBody
    public String redundancy(@RequestParam(value = "id") String id) {
        if(registerService.checkIDRedundancy(id)) {
            return "true";
        }
        else {
            return "false";
        }
    }

    @PostMapping
    public String registerMethod(@ModelAttribute Member member) {
        registerService.saveMemberInfo(member);
        return "redirect:/";
    }

}
