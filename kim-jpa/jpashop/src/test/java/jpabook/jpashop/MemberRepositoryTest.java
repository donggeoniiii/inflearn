package jpabook.jpashop;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;

@SpringBootTest
class MemberRepositoryTest {

	@Autowired
	MemberRepository memberRepository;

	@Test
	@Transactional // 엔티티 매니저를 통한 조작은 트랜잭션이 필수, 즉 테스트 끝나고 롤백
	void saveAndFindMember() {
		// given
		Member member = new Member();
		member.setName("test");

		// when
		Long savedId = memberRepository.save(member);
		Member findMember = memberRepository.find(savedId);

		// then
		assertThat(findMember.getId()).isEqualTo(member.getId());
		assertThat(findMember.getName()).isEqualTo(member.getName());
		assertThat(findMember).isEqualTo(member); // 같은 영속성 컨테스트면 id 값이 같으면 동일(==)
	}
}