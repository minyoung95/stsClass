package com.java.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.java.dto.StuDto;

@Service // 사용하고 싶은 객체에 붙이기
public class BServiceImpl implements BService {

	@Override
	public String slist() {
		
		ArrayList<StuDto> list = new ArrayList<>();
		return "stu여러개보냄";
	}
}
