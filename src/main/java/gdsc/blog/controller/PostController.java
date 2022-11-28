package gdsc.blog.controller;

import gdsc.blog.domain.Post;
import gdsc.blog.dto.post.WritePostReq;
import gdsc.blog.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/post")
@RestController // @Controller + @ResponseBody
public class PostController {
    private final PostService postService;

    @ApiOperation(value = "게시글을 등록", notes = "게시글을 등록합니다.")
    @PostMapping("")
    public ResponseEntity<Post> save(@RequestBody WritePostReq writePostReq){
        return new ResponseEntity<>(postService.save(writePostReq), HttpStatus.CREATED);
    }

    @ApiOperation(value = "게시글 전체 조회", notes = "모든 게시글을 조회합니다.")
    @GetMapping("")
    public ResponseEntity<List<Post>> findAll(){
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }

    @ApiParam(name = "id", value= "게시글 아이디")
    @ApiOperation(value = "단건 조회", notes = "게시글 id를 이용하여 단건 조회합니다.")
    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id){
        return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
    }

    @ApiImplicitParam(name = "id", value = "게시글 아이디")
    @ApiOperation(value = "게시글 단건 수정", notes = "id에 해당하는 게시글을 수정합니다.") @PutMapping("/{id}")
    public ResponseEntity<Post> updateById(@PathVariable Long id, @RequestBody WritePostReq writePostReq) {
        return new ResponseEntity<>(postService.updateById(id, writePostReq), HttpStatus.OK);
    }

    @ApiImplicitParam(name = "id", value = "게시글 아이디")
    @ApiOperation(value = "게시글 단건 삭제", notes = "id에 해당하는 게시글을 삭제합니다.") @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(postService.deleteById(id), HttpStatus.OK);
    }
}
