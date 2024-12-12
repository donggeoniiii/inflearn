package hello.hellospring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import hello.hellospring.domain.Member;


public class MemoryMemberRepository implements MemberRepository {
	private static Map<Long, Member> members = new HashMap<>();
	private static long sequence = 0L;

	@Override
	public Member save(Member member) {
		// id는 1부터
		member.setId(++sequence);
		members.put(member.getId(), member);
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		return Optional.ofNullable(members.get(id));
	}

	@Override
	public Optional<Member> findByName(String name) {
		return members.values().stream()
			.filter(member -> member.getName().equals(name))
			.findAny();
	}

	@Override
	public List<Member> findAll() {
		return new ArrayList<>(members.values());
	}

	public void clear() {
		members.clear();
	}
}
