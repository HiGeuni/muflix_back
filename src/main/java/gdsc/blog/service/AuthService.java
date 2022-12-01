package gdsc.blog.service;

import gdsc.blog.domain.User;
import gdsc.blog.dto.User.WriteUserReq;
import gdsc.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    // 회원 가입 시 사용될 로직
    @Transactional
    public User signup(WriteUserReq writeUserReq) {
        User user = User.builder()
                .email(writeUserReq.getEmail())
                .nickname(writeUserReq.getNickname())
                .phoneNumber(writeUserReq.getPhoneNumber())
                .password(writeUserReq.getPassword())
                .build();
        return userRepository.save(user);
    }
    // 회원 조회를 위해 사용될 로직
    @Transactional(readOnly = true)
    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Id에 해당하는 유저가 없습니다.")
        );
    }
    // 전체 회원 조회를 위해 사용될 로직
    @Transactional(readOnly = true)
    public List<User> findAll() {return userRepository.findAll();}

    // 회원 정보 수정을 위해 사용될 로직
    @Transactional
    public User updateById(Long id, WriteUserReq writeUserReq){
        User user = userRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("ID에 해당하는 user가 없습니다.")
        );
        user.setEmail(writeUserReq.getEmail());
        user.setNickname(writeUserReq.getNickname());
        user.setPhoneNumber(writeUserReq.getPhoneNumber());
        user.setPassword(writeUserReq.getPassword());
        return user;
    }
    // 회원 삭제를 위해 사용될 로직
    @Transactional
    public String deleteById(Long id){
        try{
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new NoSuchElementException("ID에 해당하는 user가 없습니다.");
        }
        return "OK";
    }
}
