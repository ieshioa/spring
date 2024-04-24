package com.green.board;

import com.green.board.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
/*
웹서버의 목적 :
1. 화면을 보여주기 - @Controller
2. 데이터 주기 - @RestController
 */
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {
    @Autowired  // 주소값 주입 방법1
    private final BoardService service;

//    @Autowired   // 방법2
//    public void setService(BoardService service) {
//        this.service = service;
//    }

    @PostMapping
    public int postBoard(@RequestBody BoardPostReq p) { // RequestBody얘를 생략하면 홈 데이터 형태로 넘어오는 것을 받을 수 있음
                                                        // 붙이면 제이슨형태로
        System.out.println(p);
        service.postBoard(p);

        return 10;
    }

    @GetMapping // (get) url :  /board
    public List<BoardGetRes> getBoardList() {
        return service.getBoardList();
    }

    @GetMapping("{boardId}")  // path variable  (get) /board/45
    public BoardGetDetailRes getBoardOne(@PathVariable long boardId) {  // 입력된 값을 받겠다
        return service.getBoardOne(boardId);
    }

    @GetMapping("{boardId}/{ddd}")  //  (get) board/45/asf
    public BoardGetDetailRes getBoardOne2(@PathVariable long boardId, @PathVariable String ddd) {  // 입력된 값을 받겠다
        return service.getBoardOne(boardId);
    }


    @DeleteMapping
    public int deleteBoard(@RequestParam(name="board_id") int boardId) {

        return service.deleteBoard(boardId);
    }

//    @DeleteMapping
//    public int deleteBoard(@RequestParam(name="board_id", required = false, defaultValue = "0") int boardId) {
//
//        return service.deleteBoard(boardId);
//    }  // 이렇게 하면 값을 안넣어줘도 됨. 디폴트 값을 지정해줘야함

    @PutMapping
    public int putBoard(@RequestBody BoardPutReq p){
        return service.putBoard(p);
    }

    // 대량의 데이터가 넘어오면 무조건 제이슨
    // 쿼리스트링 : url에서 주는거, ?로 시작

}
