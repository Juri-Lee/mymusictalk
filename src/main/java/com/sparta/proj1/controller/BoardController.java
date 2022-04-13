package com.sparta.proj1.controller;

import com.sparta.proj1.domain.BoardRepository;
import com.sparta.proj1.domain.BoardRequestDto;
import com.sparta.proj1.domain.Boards;
import com.sparta.proj1.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @PostMapping("/api/boards")
    public Boards createBoard(@RequestBody BoardRequestDto requestDto){
        Boards board = new Boards(requestDto);
        return boardRepository.save(board);
    }

    @GetMapping("/api/boards")
    public List<Boards> getBoards(){
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }
    @GetMapping ("/api/boards/{id}")
    public Boards getBoardsById(@PathVariable Long id ){
        try{
            Optional<Boards> board = boardRepository.findById(id);
            if(board.isPresent()){
                return board.get();
            }else{
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }

    @DeleteMapping("/api/boards/{id}")
    public Long deleteBoard(@PathVariable Long id){
        boardRepository.deleteById(id);
        return id;
    }
    @PutMapping("/api/boards/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
        boardService.update(id,requestDto);
        return id;
    }

}
