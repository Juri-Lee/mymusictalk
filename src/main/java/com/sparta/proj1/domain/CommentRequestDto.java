package com.sparta.proj1.domain;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private String contents;
    private Long contentId;
    private String username;

}
