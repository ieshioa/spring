package com.green.board;

import com.green.board.model.BoardPostReq;
import com.green.board.model.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
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
                                                        // 붙이면 뭐라구요? 제이슨
        System.out.println(p);
        service.postBoard(p);

        return 10;
    }

    @DeleteMapping
    public int deleteBoard(@RequestParam int boardId) {

        return service.deleteBoard(boardId);
    }
}
