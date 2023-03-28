package com.hm.restapi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.hm.restapi.model.Board;
import com.hm.restapi.service.BoardService;

@RestController
public class BoardController {
	@Autowired
    BoardService boardService;

	/**
	 * 게시판 목록 
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/board_nsm", produces = "application/json")
    public Map<String, Object> listBoard() throws Exception {
        return boardService.getBoardList();
    }
	
	/**
	 * 게시판 등록 
	 * @param baordDto
	 * @return
	 * @throws Exception
	 */
	 @PostMapping(value = "/board_nsm", produces = "application/json")
	 public Map<String, Object> registBoard(Board board_nsm) throws Exception {
	      return boardService.registBoard(board_nsm);
	  }
	 
	 /**
	  * 게시판 조회 
	  * @param seq
	  * @return
	  * @throws Exception
	  */
	  @GetMapping(value = "/board_nsm/{seq}", produces = "application/json")
	  public Map<String, Object> getBoard(@PathVariable("seq") int seq) throws Exception {
	       return boardService.getBoard(seq);
	   }
	  
	  /**
	   * 게시판 수정 
	   * @param baordDto
	   * @return
	   * @throws Exception
	   */
	   @PutMapping(value = "/board_nsm", produces = "application/json")
	   public Map<String, Object> modifyBoard(Board board_nsm) throws Exception {
	       return boardService.modifyBoard(board_nsm);
	    }
	   
	   /**
	     * 게시판 삭제 
	     * @param seq
	     * @return
	     * @throws Exception
	     */
	    @DeleteMapping(value = "/board_nsm/{seq}", produces = "application/json")
	    public Map<String, Object> deleteBoard(@PathVariable("seq") int seq) throws Exception {
	        return boardService.deleteBoard(seq);
	    }
}