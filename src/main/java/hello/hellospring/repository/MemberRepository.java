package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // Optional null이 반환될 때 이를 처리하는 방식중 하나
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
