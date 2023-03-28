package com.hm.restapi.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.hm.restapi.model.BoardDto;
import com.hm.restapi.model.Board;

@Mapper
public interface BoardMapper {
	public List<BoardDto> selectBoardList() throws Exception;
	
	public Board selectBoard(int seq) throws Exception;

	public int insertBoard(Map<String, Object> params) throws Exception;
	
	public int updateBoard(Map<String, Object> params) throws Exception;
	
	public int deleteBoard(int seq) throws Exception;
}