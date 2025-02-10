package com.java.dao;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.Member;

@Mapper
public interface MemberMapper {

	// 로그인체크
	Member selectLogin(String id, String pw);

	// 회원가입
	void insertMember(Member mdto);

}
