package com.sparta.proj1.controller;


import com.sparta.proj1.domain.Comment;
import com.sparta.proj1.domain.CommentRepository;
import com.sparta.proj1.domain.CommentRequestDto;
import com.sparta.proj1.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @PostMapping("/api/comments")
    public Comment writeComment(@RequestBody CommentRequestDto requestDto){
        Comment comment = new Comment(requestDto);
        return commentRepository.save(comment);
    }

    @GetMapping("api/comments")
    public List<Comment> getAllComments(){
        try{
            List<Comment> comment = commentRepository.findAll();
            return comment;
        }catch (Exception e){
            return null;
        }
    }
    @GetMapping("/api/comments/{contentId}")
    public List<Comment> getComment(@PathVariable Long contentId){
        try{
            List<Comment> comment = commentRepository.findAllByContentIdOrderByModifiedAtDesc(contentId);
            return comment;
        }catch (Exception e){
            return null;
        }
    }
    @PutMapping("api/comments/{commentId}")
    public Long editComment(@PathVariable Long commentId, @RequestBody CommentRequestDto requestDto){
        commentService.update(commentId,requestDto);
        return commentId;

    }
    @DeleteMapping("/api/comments/{commentId}")
    public Long deleteComment(@PathVariable Long commentId){
        commentRepository.deleteById(commentId);
        return commentId;
    }
    @DeleteMapping("/api/comments/deleteAll/{contentId}")
    public void deleteAllComment(@PathVariable Long contentId){
        List<Comment> comment = getComment(contentId);
        if(comment == null){
            return ;
        }
        for(int i =0 ; i <comment.size(); i++){
            Comment d = comment.get(i);
            deleteComment(d.getId());
        }
        return ;
    }
}
