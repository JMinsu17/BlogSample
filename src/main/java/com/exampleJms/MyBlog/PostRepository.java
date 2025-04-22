package com.exampleJms.MyBlog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>
{
    // <내가 다룰 엔티티는 Post고, 걔 ID 타입은 Long이다> 라고 알려주는 거

    // 와! 이게 끝임!
    // 기본적인 저장(save), ID로 찾기(findById), 전부 찾기(findAll), 삭제(deleteById) 등등
    // JpaRepository가 알아서 다 만들어줌. 구현 코드 짤 필요 없음!
    // 나중에 '제목으로 찾기' 같은 거 필요하면 여기다 메소드 이름 규칙 맞춰서 추가하면 됨.
    // 예: List<Post> findByTitle(String title);
}
