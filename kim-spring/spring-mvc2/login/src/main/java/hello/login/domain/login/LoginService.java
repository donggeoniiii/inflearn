package hello.login.domain.login;

import org.springframework.stereotype.Service;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {

	private final MemberRepository memberRepository;

	/**
	 *
	 * @return null 로그인 실패
	 */
	public Member login(String username, String password) {

		return memberRepository.findByLoginId(username)
			.filter(member -> member.getPassword().equals(password))
			.orElse(null);
	}
}
