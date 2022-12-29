package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // @Service , @Controller에 @Component가 들어있다. 스프링 빈은 기본적으로 싱글톤으로 객체 생성
public class MemberController {

    private final MemberService memberService;

    @Autowired // 자동으로 미리 컨테이너에 저장해놓은 컨트롤러와 서비스를 연결
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
