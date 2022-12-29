package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // @Service , @Controller에 @Component가 들어있다. 스프링 빈은 기본적으로 싱글톤으로 객체 생성
public class MemberController {


//    @Autowired private MemberService memberService; // 필드주입도 가능하지만 사용하지 않는다.
    private final MemberService memberService;

//    @Autowired
//    public void setMemberService(MemberService memberService) { // setter 주입 방식 단점은 public 하게 노출이 된다.
//        this.memberService = memberService;
//    }

    @Autowired // 자동으로 미리 컨테이너에 저장해놓은 컨트롤러와 서비스를 연결
    public MemberController(MemberService memberService) { // 생성자 주입을 대부분 사용한다.
        this.memberService = memberService;
    }
}
