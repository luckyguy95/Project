package Alchemystar.domain.member;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Role {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    /*
     *  id:1 name:ROLE_USER
     *  id:3 name:ROLE_ADMIN
     */

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private List<UserRole> user_roles = new ArrayList<>();
}
