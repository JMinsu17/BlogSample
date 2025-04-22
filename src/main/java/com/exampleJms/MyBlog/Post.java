package com.exampleJms.MyBlog;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // JPA야, 이 클래스는 DB 테이블이랑 연결할 놈이다! 알려주는 거
@Getter // Lombok: 알아서 getter 메소드 만들어줌 (title 달라, content 달라 할 때 쓰는거)
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Lombok: 파라미터 없는 기본 생성자 만들어줌 (JPA는 기본 생성자 필요함). PROTECTED는 함부로 new Post() 못하게 막는 용도.
@AllArgsConstructor // Lombok: 모든 필드 받는 생성자 만들어줌 (테스트나 빌더 패턴 쓸 때 편함)
public class Post {

    @Id // 이게 바로 PK(Primary Key)다! 알려줌
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 알아서 ID 값 증가시켜서 넣어줌 (MySQL/PostgreSQL/H2 등에서 쓰는 방식)
    private Long id;

    @Column(nullable = false) // DB 컬럼 설정: title 컬럼이고, null 안됨!
    private String title;

    @Lob // DB에 큰 텍스트 넣을 때 (내용은 길 수 있으니까)
    @Column(nullable = false) // content 컬럼이고, null 안됨!
    private String content;

    // 생성자, Getter 등등 Lombok이 다 만들어주니 여긴 깔-끔!
    // 만약 수정 기능 필요하면 setter 대신 의미있는 메소드 만드는게 좋음 (예: updateTitle(String newTitle))
}