package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 정형화 되지 않거나 상황에 따라 구현 클래스 변경해야 하면 설정을 통해 스프링 빈으로 등록!!!

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {

//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource); // JDBC
//        return new JdbcTemplateMemberRepository(dataSource); // JDBC Template
//        return new JpaMemberRepository(em); // JPA
//    }
}

// XML로 Bean을 등록하는 방식은 이제 실무에서 거의 사용하지 않는다.