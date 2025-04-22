package com.exampleJms.MyBlog.controller;

import com.exampleJms.MyBlog.Post;
import com.exampleJms.MyBlog.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // 이 클래스는 REST API 요청 처리하는 컨트롤러다! 알려줌. 리턴값을 JSON으로 바꿔주는 기능 포함됨.
@RequestMapping("/api/posts") // 이 컨트롤러 안에 있는 모든 API 주소는 /api/posts 로 시작한다! (나중에 주소 관리 편함)
@RequiredArgsConstructor // Lombok: final이 붙은 필드를 받는 생성자를 만들어줌 -> 생성자 주입(DI) 쉽게 구현!
public class PostController {
    private final PostRepository postRepository; // final 붙여서 불변성 확보 + RequiredArgsConstructor로 생성자 주입

    // 전체 게시글 조회 API 만들기
    @GetMapping // HTTP GET 요청 처리. 위 @RequestMapping 주소(/api/posts)랑 합쳐져서 /api/posts 주소의 GET 요청을 얘가 받음.
    public List<Post> getAllPosts() {
        return postRepository.findAll(); // 레포지토리한테 "야 글 다 내놔" 시키고 받은 거 그대로 리턴.
        // 스프링 부트가 알아서 Post 리스트를 JSON 배열로 바꿔서 응답해줌! 개꿀!
    }

    // 다음엔 여기에 @PostMapping (글 생성), @GetMapping("/{postId}") (특정 글 조회) 같은 거 추가하면 됨.
}
