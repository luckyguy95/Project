package Alchemystar.domain.service;

import Alchemystar.domain.member.Member;
import Alchemystar.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserRoleService implements UserDetailsService {

    private final MemberRepository memberRepository;


    /**
     * Spring Security 필수 메소드 구현
     *
     * @param email 이메일
     * @return UserDetails
     * @throws UsernameNotFoundException 유저가 없을 때 예외 발생
     */
    @Override // 기본적인 반환 타입은 UserDetails, UserDetails를 상속받은 UserInfo로 반환 타입 지정 (자동으로 다운 캐스팅됨)
    public Member loadUserByUsername(String email) throws UsernameNotFoundException { // 시큐리티에서 지정한 서비스이기 때문에 이 메소드를 필수로 구현
        return (Member) memberRepository.findByEmail(email);
    }

    /**
     * 회원정보 저장
     *
     * @param MemberDto 회원정보가 들어있는 DTO
     * @return 저장되는 회원의 PK
     */

    public Long save(MemberDto memberDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        memberDto.setPassword(encoder.encode(memberDto.getPassword()));

        Member build = Member.builder()
                .id(memberDto.getId())
                .loginId(memberDto.getLoginId())
                .email(memberDto.getEmail())
                .name(memberDto.getName())
                .auth(memberDto.getAuth())
                .password(memberDto.getPassword()).build();

        return memberRepository.save(build);
    }
//
//    @Transactional //변경
//    public Long register(Member member) {
//        validateDuplicateMember(member); //중복 회원 검증
//        memberRepository.save(member);
//        return member.getId();
//    }
//
//    private void validateDuplicateMember(Member member) {
//        List<Member> findMembers =
//                memberRepository.findByName(member.getName());
//        if (!findMembers.isEmpty()) {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        }
//    }
//
//    public List<Member> findMembers() {
//        return memberRepository.findAll();
//    }
//    public Member findOne(Long memberId) {
//        return memberRepository.findOne(memberId);
//    }

}
