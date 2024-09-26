package hello.hellospring.repository;

import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.Member;
import jakarta.persistence.EntityManager;

public class JpaMemberRepository implements MemberRepository {

	private final EntityManager entityManager;

	public JpaMemberRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Member save(Member member) {
		entityManager.persist(member);
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		Member member = entityManager.find(Member.class, id);
		return Optional.ofNullable(member);
	}

	@Override
	public Optional<Member> findByName(String name) {
		// jpql(jpa query language): 객체를 대상으로 날리는 쿼리문, 알아서 sql로 번역됨
		List<Member> result = entityManager.createQuery("select m from Member m where m.name = :name", Member.class)
			.setParameter("name", name)
			.getResultList();

		return result.stream().findAny();
	}

	@Override
	public List<Member> findAll() {
		return entityManager.createQuery("select m from Member m", Member.class)
			.getResultList();
	}
}
