package Alchemystar.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        log.info("home");
        return "index";
    }

    //로그인
    @GetMapping("/login")
    public String login() {
        log.info("login");
        return "basic/login";
    }

    //로그인/회원가입
    @GetMapping("/register")
    public String register() {
        log.info("login");
        return "basic/register";
    }




}
