package Alchemystar.domain.service;

import Alchemystar.domain.member.Member;
import lombok.Data;


@Data
public class MemberDto {

    private Long id;
    private String loginId;

    private String email;
    //nickname
    private String name;
    private String password;
    private String auth;

    public MemberDto(Member member) {
        this.id = member.getId();
        this.loginId = member.getLoginId();
        this.email = member.getEmail();
        this.name = member.getName();
        this.password = member.getPassword();
        this.auth = member.getAuth();
    }
}
