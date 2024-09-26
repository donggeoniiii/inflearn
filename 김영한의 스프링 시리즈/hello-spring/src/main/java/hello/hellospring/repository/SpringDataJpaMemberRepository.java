package hello.hellospring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.hellospring.domain.Member;

// Spring Data JPA가 알아서 기본적인 CRUD, 페이징 등에 필요한 쿼리 메소드를 다 제공한다
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

	// 커스텀 메소드도 규칙에 맞게 명명하면 알아서 JPQL로 짜줌
	@Override
	Optional<Member> findByName(String name); // (JPQL) select m from Member m where m.name = ?

	// 동적 쿼리는 Querydsl을 사용하자!
	// 안되면 네이티브 쿼리(직접 작성), JdbcTemplate 사용
}
