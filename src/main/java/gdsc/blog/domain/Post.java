package gdsc.blog.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor  // 인자가 없는 생성자
@AllArgsConstructor // 모든 인자를 가진 생성자
@Builder            // Builder 패턴을 사용하여 객체를 생성하는 방법
@Entity             // 이 클래스가 Entity이다.
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 50000)
    private String content;
}
