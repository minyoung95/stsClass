package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MMapper;
import com.java.dto.MemberDto;

@Service
public class MServiceImpl implements MService {

	@Autowired MMapper mMapper;
	
	@Override
	public MemberDto login(MemberDto mdto) {
		
		MemberDto memberDto = mMapper.selectLogin(mdto);
		return memberDto;
	}

}
