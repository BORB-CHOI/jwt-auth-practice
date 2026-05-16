package com.likelion.jwt.domain.board.repository;

import com.likelion.jwt.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
