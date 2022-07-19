package Alchemystar.domain.repository;

import Alchemystar.domain.member.User;

import java.util.List;

public interface CustomizedUserRepository {

    List<User> findByUsernameCustom(String username);

}
