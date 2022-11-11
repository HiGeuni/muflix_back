// 이게 레포지토리 끝!
package gdsc.blog.repository;

import gdsc.blog.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}