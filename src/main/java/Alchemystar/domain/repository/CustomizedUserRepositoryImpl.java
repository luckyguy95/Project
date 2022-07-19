package Alchemystar.domain.repository;

import Alchemystar.domain.member.QUser;
import Alchemystar.domain.member.User;
import com.querydsl.jpa.impl.JPAQuery;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomizedUserRepositoryImpl implements CustomizedUserRepository{
    @PersistenceContext
    private EntityManager em;



    @Override
    public List<User> findByUsernameCustom(String username) {
        QUser qUser = QUser.user;
        JPAQuery<?> query = new JPAQuery<Void>(em);
        List<User> users = query.select(qUser)
                .from(qUser)
                .where(qUser.username.contains(username))
                .fetch();
        return users;

    }

}
