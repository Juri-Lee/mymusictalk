package com.sparta.proj1.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Boards extends Timestamped{
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Id
    @Column(name="board_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String username;

    public Boards(String username,String contents, String title ){
        this.username = username;
        this.contents = contents;
        this.title = title;
    }

    public Boards(BoardRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

    public void update(BoardRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }


}
