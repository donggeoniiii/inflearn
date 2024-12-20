package hello.springmvc.basic;

import lombok.Data;

@Data // @RequiredArgsConstructor, @EqualsAndHashCode, @Getter, @Setter, @ToString 자동 생성
public class HelloData {
	private String username;
	private int age;
}
