package Alchemystar.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BoardController {
    @GetMapping("/rest")
    public Model board(Model model) {
        log.info("asdasd");
        String text="";
        model.addAttribute(text, "etefla");
        return model;
    }
}
