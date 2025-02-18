package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MBMapper;
import com.java.dto.MemberBoardDto;

@Service
public class MypageServiceImpl implements MypageService {

	@Autowired MBMapper mbMapper;
	
	@Override
	public ArrayList<MemberBoardDto> selectAll() {
		
		ArrayList<MemberBoardDto> list = mbMapper.selectAll();
		return list;
	}

}
