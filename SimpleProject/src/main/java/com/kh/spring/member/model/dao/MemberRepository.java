package com.kh.spring.member.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.member.model.dto.MemberDTO;

@Repository
public class MemberRepository {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public MemberDTO login(SqlSession sqlSession, MemberDTO member) {
		return sqlSession.selectOne("memberMapper.login", member);
	}
}
