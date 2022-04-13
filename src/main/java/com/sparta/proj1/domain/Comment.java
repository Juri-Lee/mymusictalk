package com.sparta.proj1.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="comment_id")
    private Long id;

    @Column(nullable = false, name="board_id")
    private Long contentId;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String username;

    public Comment(String username,String contents, Long contentId ){
        this.username = username;
        this.contents = contents;
        this.contentId= contentId;

    }

    public Comment(CommentRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.contentId = requestDto.getContentId();
        this.contents = requestDto.getContents();
    }

    public void update(CommentRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.contentId = requestDto.getContentId();
        this.contents = requestDto.getContents();
    }

    public Long getId() {
        return this.id;
    }
}
