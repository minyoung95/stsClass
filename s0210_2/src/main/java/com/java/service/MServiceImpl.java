package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberMapper;
import com.java.dto.MemberDto;

@Service
public class MServiceImpl implements MService{

	@Autowired MemberMapper memberMapper;
	
	@Override
	public MemberDto login(MemberDto mdto) {
		MemberDto memberDto = memberMapper.login(mdto);
		return memberDto;
	}

}
