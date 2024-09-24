package hello.hellospring.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

class MemberServiceTest {
	private MemberService memberService;
	private MemberRepository memberRepository;

	// 의존성 주입
	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}

	@AfterEach
	public void afterEach() {
		memberRepository.clear();
	}

	@Test
	void 회원가입() { // 테스트명은 한글로 쓰기도 함
		// given
		Member member = new Member();
		member.setName("동건");

		// when
		Long saveId = memberService.join(member);

		// then
		Member result = memberService.findMember(saveId).get();
		assertThat(saveId).isEqualTo(result.getId());
	}

	@Test
	void 중복_회원_예외() {
		// given
		Member member = new Member();
		member.setName("동건");
		Member duplicateMember = new Member();
		duplicateMember.setName("동건");

		// when
		memberService.join(member);
		/*try {
			memberService.join(duplicateMember);
			fail("예외 발생 안함");
		} catch (IllegalStateException e) {
			assertThat(e.getMessage()).isEqualTo("이미 등록된 회원입니다.");
		}*/
		// 해당 예외를 던지는지 체크(다른 예외여도 fail)
		assertThrows(IllegalStateException.class, () -> memberService.join(duplicateMember));
	}
}