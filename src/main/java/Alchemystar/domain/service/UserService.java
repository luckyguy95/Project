package Alchemystar.domain.service;

import Alchemystar.domain.member.Role;
import Alchemystar.domain.member.User;
import Alchemystar.domain.member.UserRole;
import Alchemystar.domain.model.Board;
import Alchemystar.domain.repository.UserRepository;
import Alchemystar.domain.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor

public class UserService {

    private UserRepository userRepository;

    private UserRoleRepository userRoleRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserRole CreateUserRole(User user, Role role) {
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRoleRepository.save(userRole);
        return userRole;
    }


    public void save(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        Role role = new Role();
        role.setId(1l);

        UserRole userRole = CreateUserRole(user, role);
        user.getUser_roles().add(userRole);

        userRepository.save(user);
    }

}
