package hamster.demo.service;

import hamster.demo.domain.Member;
import hamster.demo.repository.Member.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository repository;
    @BeforeEach
    public void beforEach(){
        repository = new MemoryMemberRepository();
        memberService = new MemberService(repository);
    }
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    void 회원가입() {
        //given 무언가 주어지면
        Member member = new Member();
        member.setName("hamster");
        //when 실행하면
        long saveID = memberService.Join(member);

        //then 결과가 나온다
        Member findMember = memberService.findOne(saveID).get();
        assertThat(member.getName()).isEqualTo(findMember.getName()); // Static Import = Alt+Enter
    }

    @Test
    public void 중복회원검증(){
        //given
        Member member1 = new Member();
        member1.setName("hemmu123");

        Member member2 = new Member();
        member2.setName("hemmu123"); //똑같은 멤버 2개 생성

        //when
        memberService.Join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.Join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try {
//            memberService.Join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }


        //then

    }

    @Test
    void 멤버전체조회() {
    }

    @Test
    void 멤버하나조회() {
    }
}