package gdsc.blog.service;

import gdsc.blog.domain.Music;
import gdsc.blog.dto.music.WriteMusicReq;
import gdsc.blog.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MusicService {
    private final MusicRepository musicRepository;

    @Transactional
    public Music save(WriteMusicReq writeMusicReq){
        Music music = Music.builder()
                .name(writeMusicReq.getName())
                .singer(writeMusicReq.getSinger())
                .albumCover(writeMusicReq.getAlbumCover())
                .build();
        return musicRepository.save(music);
    }

    @Transactional(readOnly = true)
    public List<Music> findAll() { return musicRepository.findAll(); }

    @Transactional(readOnly = true)
    public Music findById(Long id){
        return musicRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("ID에 해당하는 Music이 없습니다.")
        );
    }

    @Transactional
    public Music updateById(Long id, WriteMusicReq writeMusicReq){
        Music music = musicRepository.findById(id).orElseThrow( () -> new NoSuchElementException("ID에 해당하는 Music이 없습니다."));
        music.setName(writeMusicReq.getName());
        music.setSinger(writeMusicReq.getSinger());
        music.setAlbumCover(writeMusicReq.getAlbumCover());
        return music;
    }

    @Transactional
    public String deleteById(Long id){
        try{
            musicRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new NoSuchElementException("id를 확인해주세요!!");
        }
        return "OK";
    }
}
