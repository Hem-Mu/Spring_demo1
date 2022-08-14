package hamster.demo.service;

import hamster.demo.domain.Member;
import hamster.demo.repository.Member.MemberRepository;
import hamster.demo.repository.Member.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*회원가입*/
    public long Join(Member member){
        //같은 이름 회원 제외
        /*
        Optional<Member> result = memberRepository.findByName(member.getName()); //member 이름 검색해서
        result.ifPresent(member1 -> { //멤버의 이름이 있을 경우
            throw new IllegalStateException("이미 존재하는 회원입니다."); // 텍스트 출력
        });
        */

        validateDuplicateMember(member); //중복회원 검증 메소드 메소드 / 생성 단축키ctrl+alt+shift+t
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) //위 코드의 optional을 바로 반환할 수 있음
        .ifPresent(member1 -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
    /*
    전체회원조회
     */
    public List<Member> findMember(){
        return memberRepository.findAll();
    }
    /*
    회원 하나조회
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findByID(memberId);
    }
}
