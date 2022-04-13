package com.sparta.proj1.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BoardRepository extends JpaRepository<Boards,Long> {
    List<Boards> findAllByOrderByModifiedAtDesc();

}
