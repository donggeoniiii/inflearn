package jpabook.jpashop.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.dto.MemberForm;
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
		MemberForm memberForm = new MemberForm();
		memberForm.setName("test");

		// when
		Long savedId = memberService.join(memberForm);

		// then
		Member member = memberRepository.findOne(savedId);
		assertThat(member.getName()).isEqualTo("test");
	}

	@Test
	void 중복_회원_예외() {
		// given
		MemberForm memberForm = new MemberForm();
		memberForm.setName("test");

		MemberForm duplicatedForm = new MemberForm();
		duplicatedForm.setName("test");

		// when - throws exception
		memberService.join(memberForm);
		assertThrows(IllegalStateException.class, () -> memberService.join(duplicatedForm));
	}
}