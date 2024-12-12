package hello.hellospring.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;

class MemoryMemberRepositoryTest {
	MemoryMemberRepository memberRepository = new MemoryMemberRepository();

	// 테스트 간의 독립성을 위해 저장소 초기화
	@AfterEach
	public void afterEach() {
		memberRepository.clear();
	}

	@Test
	public void save() {
		Member member  = new Member();
		member.setName("donggeon");
		memberRepository.save(member);

		Member result = memberRepository.findById(member.getId()).get(); // get()으로 꺼내는건 권장되진 않음
		assertThat(result).isEqualTo(member);
	}

	@Test
	public void findById() {
		Member member = new Member();
		member.setName("donggeon");
		memberRepository.save(member);

		Long result = memberRepository.findById(member.getId()).get().getId();
		assertThat(result).isEqualTo(member.getId());
	}

	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("donggeon");
		memberRepository.save(member1);

		Member member2 = new Member();
		member2.setName("donggeoniiii");
		memberRepository.save(member2);

		Member result = memberRepository.findByName("donggeon").get();
		assertThat(result).isEqualTo(member1);
	}

	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("donggeon");
		memberRepository.save(member1);

		Member member2 = new Member();
		member2.setName("donggeoniiii");
		memberRepository.save(member2);

		List<Member> result = memberRepository.findAll();
		assertThat(result.size()).isEqualTo(2);
	}
}