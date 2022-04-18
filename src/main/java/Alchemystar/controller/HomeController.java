package Alchemystar.controller;

import Alchemystar.domain.member.User;
import Alchemystar.domain.service.MemberDto;
import Alchemystar.domain.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        log.info("home");
        return "index";
    }
    //로그인
    //로그인/회원가입
    @GetMapping("/register")
    public String register() {
        log.info("register");
        return "basic/register";
    }


    @PostMapping("/register")
    public String register(User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/terms")
    public String termsGet() {
        log.info("terms GetMapping");
        return "basic/terms";
    }







}
