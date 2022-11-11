package gdsc.blog.service;

import gdsc.blog.domain.Post;
import gdsc.blog.dto.post.WritePostReq;
import gdsc.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service                    // 해당 클래스를 Spring Container에 빈으로 등록 후, Spring MVC 서비스로 표
@RequiredArgsConstructor    // final 또는 @NotNull이 붙은 필드의 생성자를 자동으로 생성해준다.
public class PostService {
    // Spring project에 싱글톤으로 생성되고 관리되는 PostRepository Bean을 의존성 주입 받는다.
    private final PostRepository postRepository;

    @Transactional // 해당 함수 종료 시, commit 또는 Rollback 수행 (트랜잭션 관리)
    public Post save(WritePostReq writePostReq){
        Post post = Post.builder()
                    .title(writePostReq.getTitle())
                    .content(writePostReq.getContent())
                    .build();
        return postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public List<Post> findAll(){
        return postRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Post findById(Long id){
        return postRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("ID에 해당하는 Post가 없습니다.")
        );
    }

    @Transactional
    public Post updateById(Long id, WritePostReq writePostReq){
        Post post = postRepository.findById(id).orElseThrow( () -> new NoSuchElementException("ID에 해당하는 Post가 없습니다."));
        post.setTitle(writePostReq.getTitle());
        post.setContent(writePostReq.getContent());
        return post;
    }

    @Transactional
    public String deleteById(Long id) {
        try {
            postRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NoSuchElementException("id를 확인해주세요!!"); }
        return "ok";
    }

}
