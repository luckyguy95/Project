package Alchemystar.domain.service;

import Alchemystar.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

//@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {
    @Autowired
    UserRoleService memberService;
    @Autowired
    MemberRepository memberRepository;
//    @Test
//    public void 회원가입() throws Exception {
//        //Given
//        Member member = new Member();
//        member.setNickname("kim");
//        //When
//        Long saveId = memberService.register(member);
//        //Then
//        assertEquals(member, memberRepository.findById(saveId));
//    }
//    @Test(expected = IllegalStateException.class)
//    public void 중복_회원_예외() throws Exception {
//        //Given
//        Member member1 = new Member();
//        member1.setName("kim");
//        Member member2 = new Member();
//        member2.setName("kim");
//        //When
//        memberService.join(member1);
//        memberService.join(member2); //예외가 발생해야 한다.
//        //Then
//        fail("예외가 발생해야 한다.");
//    }
}