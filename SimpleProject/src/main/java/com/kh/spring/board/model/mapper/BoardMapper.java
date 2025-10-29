package com.kh.spring.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import com.kh.spring.api.model.dto.comment;
import com.kh.spring.board.model.dto.BoardDTO;
import com.kh.spring.board.model.dto.ReplyDTO;

@Mapper
public interface BoardMapper {
	
	int selectTotalCount();
	
	List<BoardDTO> findAll(RowBounds rowbounds);
	
	int save(BoardDTO board);
	
	int increaseCount(Long boardNo);
	
	BoardDTO findByBoardNo(Long boardNo);
	
	BoardDTO findByBoardAndReply(Long boardNo);
	
	int insertReply(ReplyDTO reply);
	
	@Insert("INSERT INTO FOOD_COMMENT VALUES(#{foodNo}, #{content}, SYSDATE)")
	int saveComment(comment comment);
	
	@Select("""
			SELECT
				   SEQ foodNo
				 , CONTENT
				 , CREATE_DATE createDate
		      FROM
		      	   FOOD_COMMENT
		     WHERE
		     	   SEQ = #{seq}
		     ORDER
		     	BY
		     	   createDate DESC
			""")
	List<comment> selectAll(Long seq);
}
