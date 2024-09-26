package hello.hellospring.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import hello.hellospring.domain.Member;

public class JdbcTemplateMemberRepository implements MemberRepository {

	private final JdbcTemplate jdbcTemplate;

	// @Autowired // 의존성을 주입하는 생성자가 하나면 생략 가능
	public JdbcTemplateMemberRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Member save(Member member) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("name", member.getName());

		Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
		member.setId(key.longValue());

		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		List<Member> queryResult = jdbcTemplate.query("select * from member where id = ?", memberRowMapper(), id);
		return queryResult.stream().findAny();
	}

	@Override
	public Optional<Member> findByName(String name) {
		List<Member> queryResult = jdbcTemplate.query("select * from member where name = ?", memberRowMapper(), name);
		return queryResult.stream().findAny();
	}

	@Override
	public List<Member> findAll() {
		return jdbcTemplate.query("select * from member", memberRowMapper());
	}

	private RowMapper<Member> memberRowMapper() {
		return (rs, rowNum) -> {
			Member member = new Member();
			member.setId(rs.getLong("id"));
			member.setName(rs.getString("name"));
			return member;
		};
	}
}
