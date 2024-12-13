package hello.servlet.domain.member;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {

	MemberRepository memberRepository = MemberRepository.getInstance();

	@AfterEach
	void tearDown() {
		memberRepository.clear();
	}

	@Test
	public void save() {
		// given
		Member member = new Member("icebear", 27);

		// when
		Member savedMember = memberRepository.save(member);

		// then
		assertNotNull(savedMember.getId());
	}

	@Test
	public void findById() {
		// given
		Member member = new Member("icebear", 27);
		Member savedMember = memberRepository.save(member);

		// when
		Member findMember = memberRepository.findById(savedMember.getId());

		// then
		assertThat(findMember).isEqualTo(savedMember);
	}

	@Test
	public void findAll() {
		// given
		Member member1 = new Member("icebear", 27);
		Member member2 = new Member("icebear2", 27);
		memberRepository.save(member1);
		memberRepository.save(member2);

		// when
		List<Member> members = memberRepository.findAll();

		// then
		assertThat(members.size()).isEqualTo(2);
		assertThat(members).contains(member1, member2);
	}
}