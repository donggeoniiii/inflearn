package hello.hellospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;


public class MemberService {
	private final MemberRepository memberRepository;

	// 의존성 주입(생성자)
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	/**
	 * 회원가입
	 */
	public Long join(Member member) {
		// 중복회원 검증
		validateDuplicateMember(member);

		return memberRepository.save(member).getId();
	}

	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName())
				.ifPresent(m -> {
					throw new IllegalStateException("이미 등록된 회원입니다.");
				});
	}

	/**
	 * 전체 회원 목록 조회
	 */
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	/**
	 * id로 회원 조회
	 */
	public Optional<Member> findMember(Long id) {
		return memberRepository.findById(id);
	}
}
