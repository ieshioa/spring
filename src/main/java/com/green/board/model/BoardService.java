package com.green.board.model;

// xml mapper service controller
import com.green.board.BoardMapper;
import com.green.board.model.BoardPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper mapper;

    public int postBoard(BoardPostReq p) {
        System.out.println("BoardService - postBoard");
        return mapper.postBoard(p);
    }
    public int deleteBoard(int boardId) {
        return mapper.deleteBoard(boardId);
    }

    public List<BoardGetRes> getBoardList() {
        return mapper.getBoardList();
    }

    public BoardGetDetailRes getBoardOne(long boardId) {
        return mapper.getBoardOne(boardId);
    }

    public int putBoard(BoardPutReq p) {
        return mapper.putBoard(p);
    }
}
