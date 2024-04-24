package com.green.board;

import com.green.board.model.BoardGetDetailRes;
import com.green.board.model.BoardGetRes;
import com.green.board.model.BoardPostReq;
import com.green.board.model.BoardPutReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int postBoard(BoardPostReq p); // 영향받은 행
    List<BoardGetRes> getBoardList();
    BoardGetDetailRes getBoardOne(long boardId);
    int deleteBoard(int p);
    int putBoard(BoardPutReq p);
    // 데이터를 가져오는 것(리턴)은 select만,
    // 나머지는 영향받은 행이 리턴됨
}
