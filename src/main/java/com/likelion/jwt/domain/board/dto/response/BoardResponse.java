package com.likelion.jwt.domain.board.dto.response;

import com.likelion.jwt.domain.board.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String author;

    public BoardResponse(Long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public static BoardResponse from(Board board) {
        return new BoardResponse(
                board.getId(),
                board.getTitle(),
                board.getContent(),
                board.getAuthor().getUsername()
        );
    }
}
