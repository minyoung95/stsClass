package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BMapper;
import com.java.dto.BoardDto;

@Service // 최신버전에 달아주기
public class BServiceImpl implements BService {

	@Autowired BMapper bMapper;
	
	@Override
	public ArrayList<BoardDto> blist() {
		ArrayList<BoardDto> list = bMapper.blist();
		
		System.out.println("BserviceImpl 갯수 : "+list.size());
		
		
		return list;
	}

}
