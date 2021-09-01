package Alchemystar.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Repository
public class MemberRepository {

    private static ConcurrentMap<Long, Member> store = new ConcurrentHashMap<>();

    private static AtomicLong sequence = new AtomicLong(0);


    public Member save(Member member) {
        store.put(sequence.longValue(), member);
        member.setId(sequence.getAndIncrement());
        log.info("save: member={}", member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public Optional<Member> findByLoginId(String loginId) {
        return findAll().stream()
                .filter(member -> member.getLoginId().equals(loginId))
                .findFirst();
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    public void clearStore() {
        store.clear();
    }



}
