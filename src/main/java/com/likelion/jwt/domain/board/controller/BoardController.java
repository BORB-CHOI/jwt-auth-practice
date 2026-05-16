package com.likelion.jwt.domain.board.controller;

import com.likelion.jwt.domain.board.dto.request.BoardCreateRequest;
import com.likelion.jwt.domain.board.dto.request.BoardUpdateRequest;
import com.likelion.jwt.domain.board.dto.response.BoardResponse;
import com.likelion.jwt.domain.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<BoardResponse> create(@AuthenticationPrincipal UserDetails userDetails,
                                                @Valid @RequestBody BoardCreateRequest request) {
        return ResponseEntity.ok(boardService.create(userDetails.getUsername(), request));
    }

    @GetMapping
    public ResponseEntity<List<BoardResponse>> findAll() {
        return ResponseEntity.ok(boardService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardResponse> update(@PathVariable Long id,
                                                @Valid @RequestBody BoardUpdateRequest request) {
        return ResponseEntity.ok(boardService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boardService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
