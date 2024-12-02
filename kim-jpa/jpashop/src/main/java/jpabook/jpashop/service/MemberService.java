package jpabook.jpashop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true) // 조회 메서드 실행 시 리소스 절약을 위해 읽기 전용 트랜잭션으로 표시
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	// 회원 가입
	@Transactional // 메서드에 붙은 트랜잭션 어노테이션이 우선, 얘만 쓰기 트랜잭션임을 표시
	public Long join(Member member) {
		// 중복회원일 시 예외 처리
		validateDuplicateMember(member);

		memberRepository.save(member);

		return member.getId();
	}

	private void validateDuplicateMember(Member member) {
		List<Member> members = memberRepository.findAll();

		if (!members.isEmpty()) {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		}
	}

	// 회원 전체 조회
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	// 회원 단건 조회
	public Member findMember(Long memberId) {
		return memberRepository.findOne(memberId);
	}
}
