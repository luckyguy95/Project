//package Alchemystar.controller;
//
//import Alchemystar.domain.member.Member;
//import Alchemystar.domain.member.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.validation.Valid;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/members")
//public class MemberController {
//
//    private final MemberRepository memberRepository;
//
//    @GetMapping("/add")
//    public String addForm(@ModelAttribute("member")Member member) {
//        return "members/addMemberForm";
//    }
//
////    @PostMapping("/add")
////    public String save(@Valid @ModelAttribute Member membe)
//
//}
