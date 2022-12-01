package gdsc.blog.repository;

import gdsc.blog.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MusicRepository extends JpaRepository<Music, Long> {
    Optional<Music> findByName(String name);
}
