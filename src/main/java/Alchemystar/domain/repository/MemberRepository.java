package Alchemystar.domain.repository;

import Alchemystar.domain.member.Member;
import Alchemystar.domain.member.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Repository
public class MemberRepository  {

    private static ConcurrentMap<Long, Member> store = new ConcurrentHashMap<>();

    private static AtomicLong sequence = new AtomicLong(0);

    @PersistenceContext
    private EntityManager em;

    JPAQueryFactory query = new JPAQueryFactory(em);
    QMember m = QMember.member;


//    public Member save(Member member) {
//        store.put(sequence.longValue(), member);
//        member.setId(sequence.getAndIncrement());
//        log.info("save: member={}", member);
//        return member;
//    }

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member findById(Long id) {
        return em.find(Member.class, id);
    }

    public Optional<Member> findByLoginId(String loginId) {
        return findAll().stream()
                .filter(member -> member.getLoginId().equals(loginId))
                .findFirst();
    }

//    public Member findByEmail(String email) {
//        return
//    }

    public List<Member> findByName(String name) {
        return query.selectFrom(m)
                .where(m.name.eq(name))
                .fetch();
    }

    public List<Member> findAll() {
        return query.selectFrom(m)
                .fetch();
    }

    public void clearStore() {
        store.clear();
    }


    public List<Member> findByEmail(String email) {
        return query.selectFrom(m)
                .where(m.email.eq(email))
                .fetch();
    }
}
