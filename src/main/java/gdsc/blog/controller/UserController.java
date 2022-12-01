package gdsc.blog.controller;

import gdsc.blog.domain.User;
import gdsc.blog.dto.User.WriteUserReq;
import gdsc.blog.repository.UserRepository;
import gdsc.blog.service.AuthService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/auth")
@RestController
public class UserController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@Valid @RequestBody WriteUserReq writeUserReq) {
        return new ResponseEntity<>(authService.signup(writeUserReq), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<User>> findAll(){
        return new ResponseEntity<>(authService.findAll(), HttpStatus.OK);
    }

    @ApiParam(name="id", value="User id")
    @ApiOperation(value = "User 조회 Using ID", notes = "User id를 이용한 단건 조회")
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return new ResponseEntity<>(authService.findById(id), HttpStatus.OK);
    }

    @ApiParam(name="id", value = "User id")
    @ApiOperation(value = "User 수정", notes = "User id에 해당하는 유저 정보 수정")
    @PostMapping("/{id}")
    public ResponseEntity<User> updateById(@PathVariable Long id, @RequestBody WriteUserReq writeUserReq){
        return new ResponseEntity<>(authService.updateById(id, writeUserReq), HttpStatus.OK);
    }

    @ApiParam(name="id", value = "User id")
    @ApiOperation(value = "User 삭제", notes = "User id에 해당하는 유저 삭제")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(authService.deleteById(id), HttpStatus.OK);
    }
}
