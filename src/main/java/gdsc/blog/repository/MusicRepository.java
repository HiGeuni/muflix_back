package gdsc.blog.repository;

import gdsc.blog.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {
}
