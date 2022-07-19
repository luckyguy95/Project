package Alchemystar.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Controller
public class TestController {
    @GetMapping("/home")
    public String getHome(){
        return "basic/test";
    }
}