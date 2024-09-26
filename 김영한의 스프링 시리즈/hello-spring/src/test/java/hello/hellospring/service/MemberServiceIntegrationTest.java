package hello.hellospring.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

@SpringBootTest // 스프링 컨테이너와 테스트를 함께 실행
@Transactional // 테스트 시작 전 트랜잭션 시작, 테스트 끝나면 롤백(반복실행 시 영향 x)
class MemberServiceIntegrationTest {
	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberRepository memberRepository;

	@Test
	// @Commit // -> 이러면 트랜잭션 끝나고 롤백 안됨!
	void 회원가입() { // 테스트명은 한글로 쓰기도 함
		// given
		Member member = new Member();
		member.setName("동건");

		// when
		Long saveId = memberService.join(member);

		// then
		Member result = memberRepository.findById(saveId).get();
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

		// 해당 예외를 던지는지 체크(다른 예외여도 fail)
		assertThrows(IllegalStateException.class, () -> memberService.join(duplicateMember));
	}

}
