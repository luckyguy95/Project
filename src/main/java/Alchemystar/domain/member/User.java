package Alchemystar.domain.member;

import Alchemystar.domain.model.Board;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String username;
    private String email;
    private String password;
    private String nickname;
    private String picture;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserRole> user_roles = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Board> boards = new ArrayList<>();

    @Builder
    public User(String email, String password, String nickname, String picture) {
        this.email = email;
        this.nickname = nickname;
        this.picture = picture;
    }

    public User update(String name, String picture) {
        this.username = username;
        this.picture = picture;

        return this;
    }

}
