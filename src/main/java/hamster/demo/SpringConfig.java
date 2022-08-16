package hamster.demo;

import hamster.demo.repository.Member.MemberRepository;
import hamster.demo.repository.Member.MemoryMemberRepository;
import hamster.demo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
