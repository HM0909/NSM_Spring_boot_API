package com.hm.restapi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hm.restapi.mapper.BoardMapper;
import com.hm.restapi.model.BoardDto;
import com.hm.restapi.model.Board;

@Service
public class BoardService {
    static final Logger logger = (Logger) LoggerFactory.getLogger(BoardService.class);

    @Autowired
    BoardMapper boardMapper;
	/**
	 * 게시판 목록
	 * @return
	 */
	public Map<String, Object> getBoardList() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {			
			List<BoardDto> result = boardMapper.selectBoardList();
			if (result.size() > 0) {
				resultMap.put("message", "success");
	        } else {
	        	resultMap.put("message", "failed");
	        }
			resultMap.put("status", HttpStatus.OK);
			resultMap.put("result", result);	
		} catch (Exception ex) {
			resultMap.put("status", HttpStatus.BAD_REQUEST);
			resultMap.put("message", "failed");
			logger.error(ex.getMessage());
		}
        return resultMap; 
    }
	
	/**
	 * 게시판 등록 
	 * @param board
	 * @return
	 */
	public Map<String, Object> registBoard(Board board_nsm) {
		 Map<String, Object> resultMap = new HashMap<String, Object>();
		 Map<String, Object> paramMap = new HashMap<String, Object>();
         
		 try {
	         paramMap.put("title", board_nsm.getTitle());
	         paramMap.put("readCount", board_nsm.getReadCount());
	         paramMap.put("linkUrl", board_nsm.getLinkUrl());
	         paramMap.put("attachUrl", board_nsm.getAttachUrl());
	         paramMap.put("content", board_nsm.getContent());
	                  
	         int ret = boardMapper.insertBoard(paramMap);         
	         	         	         
	         if (ret > 0) {
	        	 resultMap.put("result", "success");
	         } else {
	        	 resultMap.put("result", "failed");
	         }
	         
	         resultMap.put("status", HttpStatus.CREATED);
		} catch (Exception ex) {
			resultMap.put("status", HttpStatus.BAD_REQUEST);
			resultMap.put("message", "failed");
			logger.error(ex.getMessage());
		}
        return resultMap;
    }
	
	/**
	 * 게시판 조회
	 * @param seq
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getBoard(int seq) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {			
			Board result = boardMapper.selectBoard(seq);
			if (result != null) {
				resultMap.put("message", "success");
	        } else {
	        	resultMap.put("message", "failed");
	        }
			resultMap.put("status", HttpStatus.OK);
			resultMap.put("result", result);
		} catch (Exception ex) {
			resultMap.put("status", HttpStatus.BAD_REQUEST);
			resultMap.put("message", "failed");
			logger.error(ex.getMessage());
		}
        return resultMap;
    }
	
	/**
	 * 게시판 수정 
	 * @param board
	 * @return
	 */
	public Map<String, Object> modifyBoard(Board board_nsm) {
		 Map<String, Object> resultMap = new HashMap<String, Object>();
		 Map<String, Object> paramMap = new HashMap<String, Object>();
        
		 try {
			paramMap.put("seq", board_nsm.getSeq());
	        paramMap.put("title", board_nsm.getTitle());
	        paramMap.put("readCount", board_nsm.getReadCount());
	        paramMap.put("linkUrl", board_nsm.getLinkUrl());
	        paramMap.put("attachUrl", board_nsm.getAttachUrl());
	        paramMap.put("content", board_nsm.getContent());
	                 
	        int ret = boardMapper.updateBoard(paramMap);
	        
	        if (ret > 0) {
	        	resultMap.put("result", "success");
	        } else {
	        	resultMap.put("result", "failed");
	        }
	        
	        resultMap.put("status", HttpStatus.OK);
		 } catch (Exception ex) {
			resultMap.put("status", HttpStatus.BAD_REQUEST);
			resultMap.put("message", "failed");
			logger.error(ex.getMessage());			
		 }
		 return resultMap;
	}
	
	/**
	 * 게시판 삭제
	 * @param seq
	 * @return
	 */
	public Map<String, Object> deleteBoard(int seq) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
       		    
		try {
			int ret = boardMapper.deleteBoard(seq);         
			if (ret > 0) {
	   			resultMap.put("result", "success");
	   		} else {
	   			resultMap.put("result", "failed");
	   		}
	       
			resultMap.put("status", HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			resultMap.put("status", HttpStatus.BAD_REQUEST);
			resultMap.put("message", "failed");
			logger.error(ex.getMessage());			
		}
		return resultMap;
	}
}