package Alchemystar.controller;

import Alchemystar.domain.repository.MemberRepository;
import Alchemystar.domain.service.UserRoleService;
import Alchemystar.domain.service.validaiton.MemberValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberRepository memberRepository;
    private final UserRoleService memberService;
    private final MemberValidator memberValidator;

    // 회원 추가
//    @PostMapping("/register")
//    public String signup(@ModelAttribute MemberDto memberDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        memberValidator.validate(memberDto, bindingResult);
//        if( bindingResult.hasErrors()) {
//            log.info("errors={}", bindingResult);
//            return "redirect:/register";
//        }
//        memberService.save(memberDto);
//        log.info("register PM");
//        return "redirect:/login";
//    }

//    @GetMapping("/register")


    @GetMapping("/login")
    public String login() {
        return "basic/login";
    }


    @GetMapping("/logout")
    public String logout() {
        log.info("logout");
        return "redirect:/login";
    }
//
//    @GetMapping(value = "/logout")
//    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
//        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
//        return "redirect:/login";
//    }
//    @PostMapping("/add")
//    public String save(@Valid @ModelAttribute Member membe)

}
