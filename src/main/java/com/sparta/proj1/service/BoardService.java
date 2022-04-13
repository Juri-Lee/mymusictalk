package com.sparta.proj1.service;

import com.sparta.proj1.domain.BoardRepository;
import com.sparta.proj1.domain.BoardRequestDto;
import com.sparta.proj1.domain.Boards;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//update 할때 service를 사용한다.
@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long update(Long id , BoardRequestDto requestDto){
        Boards board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        board.update(requestDto);
        return board.getId();
    }


}
