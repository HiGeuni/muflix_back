package gdsc.blog.controller;

import gdsc.blog.domain.Music;
import gdsc.blog.dto.music.WriteMusicReq;
import gdsc.blog.service.MusicService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins= "*", allowedHeaders = "*")
@RequestMapping("/musics")
@RestController
public class MusicController {
    private final MusicService musicService;
    
    @ApiOperation(value = "음악 등록", notes = "음악을 등록합니다.")
    @PostMapping("")
    public ResponseEntity<Music> save(@RequestBody WriteMusicReq writeMusicReq){
        return new ResponseEntity<>(musicService.save(writeMusicReq), HttpStatus.CREATED);
    }

    @ApiOperation(value = "음악 전체 조회", notes = "전체 음악을 조회합니다.")
    @GetMapping("")
    public ResponseEntity<List<Music>> findAll() {
        return new ResponseEntity<>(musicService.findAll(), HttpStatus.OK);
    }

    @ApiParam(name = "id", value = "Music ID")
    @ApiOperation(value = "Music 조회 Using ID", notes = "Music id를 이용하여 단건 조회")
    @GetMapping("/{id}")
    public ResponseEntity<Music> findById(@PathVariable Long id){
        return new ResponseEntity<>(musicService.findById(id), HttpStatus.OK);
    }

    @ApiImplicitParam(name = "id", value = "Music ID")
    @ApiOperation(value = "Music 수정", notes = "id에 해당하는 Music을 수정합니다.")
    @PutMapping("/{id}")
    public ResponseEntity<Music> updateById(@PathVariable Long id, @RequestBody WriteMusicReq writeMusicReq){
        return new ResponseEntity<>(musicService.updateById(id, writeMusicReq), HttpStatus.OK);
    }

    @ApiImplicitParam(name = "id", value = "Music ID")
    @ApiOperation(value = "Music 삭제", notes = "id에 해당하는 게시글을 삭제합니다.")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(musicService.deleteById(id), HttpStatus.OK);
    }
}
