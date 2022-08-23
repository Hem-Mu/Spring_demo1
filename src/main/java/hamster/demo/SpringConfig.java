package hamster.demo;

import hamster.demo.repository.Member.*;
import hamster.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Autowired DataSource dataSource;
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){

       // return new MemoryMemberRepository();
      //  return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
