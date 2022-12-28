package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // java8 lambda loop 돌려서 params의 name이랑 같은지 확인하고 일치하면 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store의 value를 list로 반환
    }

    // test case 작성해서 동작 확인
}
