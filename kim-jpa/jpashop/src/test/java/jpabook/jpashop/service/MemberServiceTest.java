package jpabook.jpashop.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;

@SpringBootTest
@Transactional
class MemberServiceTest {

	@Autowired
	MemberService memberService;

	@Autowired
	MemberRepository memberRepository;

	@Test
	void 회원가입() {
		// given
		Member member = new Member();
		member.setName("test");

		// when
		Long savedId = memberService.join(member);

		// then
		assertThat(savedId).isEqualTo(member.getId());
		assertThat(memberRepository.findOne(savedId)).isEqualTo(member);
	}

	@Test
	void 중복_회원_예외() {
		// given
		Member member = new Member();
		member.setName("test");
		Member duplicatedMember = new Member();
		duplicatedMember.setName("test");

		// when - throws exception
		memberService.join(member);
		assertThrows(IllegalStateException.class, () -> memberService.join(duplicatedMember));
	}
}