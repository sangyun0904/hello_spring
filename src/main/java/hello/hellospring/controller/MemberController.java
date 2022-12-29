package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        // System.out.println("member = " + member.getName()); // input이 제대로 들어오는지 확인

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
