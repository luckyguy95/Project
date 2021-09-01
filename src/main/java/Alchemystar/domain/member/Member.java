package Alchemystar.domain.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class Member {

    private Long id;

    @NotEmpty
    private Long loginId;
    @NotEmpty
    private String name;
    @NotEmpty
    private String password;

}
