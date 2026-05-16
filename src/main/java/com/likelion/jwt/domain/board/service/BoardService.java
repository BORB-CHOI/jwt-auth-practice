package com.likelion.jwt.domain.board.service;

import com.likelion.jwt.domain.board.dto.request.BoardCreateRequest;
import com.likelion.jwt.domain.board.dto.request.BoardUpdateRequest;
import com.likelion.jwt.domain.board.dto.response.BoardResponse;
import com.likelion.jwt.domain.board.entity.Board;
import com.likelion.jwt.domain.board.repository.BoardRepository;
import com.likelion.jwt.domain.member.entity.Member;
import com.likelion.jwt.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public BoardResponse create(String username, BoardCreateRequest request) {
        Member author = memberRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다: " + username));

        Board board = Board.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .author(author)
                .build();

        return BoardResponse.from(boardRepository.save(board));
    }

    @Transactional(readOnly = true)
    public List<BoardResponse> findAll() {
        return boardRepository.findAll().stream()
                .map(BoardResponse::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public BoardResponse findById(Long id) {
        return BoardResponse.from(getBoard(id));
    }

    @Transactional
    public BoardResponse update(Long id, BoardUpdateRequest request) {
        Board board = getBoard(id);
        board.update(request.getTitle(), request.getContent());
        return BoardResponse.from(board);
    }

    @Transactional
    public void delete(Long id) {
        Board board = getBoard(id);
        boardRepository.delete(board);
    }

    private Board getBoard(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다: " + id));
    }
}
