package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // findAll(), save() 등등 기본적인 기능들은 선언할 필요도 없이 JpaRepository에서 가져다 쓴다. => Jump to source

    // findByName ==> JPOL select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
    // Optional<Member> findByNameAndId(String name, Long id); // And, Or도 가능
}
