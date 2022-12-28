package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 하나의 test가 끝날때마다 실행
    public void afterEach() {
        repository.clearStore(); // repository 저장소 지움
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member, result); // result 와 member 두 객체가 같은지 확인 다르면 에러
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        Assertions.assertEquals(member1, result); // findByName "spring1" ok, "spring2" assertion error
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertEquals(2, result.size());

        // 전체 테스트를 돌렸을 때 findAll() 이 먼저 실행되면서 spring1, spring2 name을 가진 객체가 앞에 저장되어 버림 findByName() error
        // test를 먼저 만들고 구현 클래스를 만들면 test 주도 개발 (tdd)
    }

}
