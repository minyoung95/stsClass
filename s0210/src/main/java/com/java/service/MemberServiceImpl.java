package com.java.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberMapper;
import com.java.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	
	@Override // 로그인확인
	public Member login(String id, String pw) {
		
		// Dao 보냄
		Member memberDto = memberMapper.selectLogin(id,pw);
		return memberDto;
	}

	@Override
	public void member(Member mdto) {
		memberMapper.insertMember(mdto);
	}

}
