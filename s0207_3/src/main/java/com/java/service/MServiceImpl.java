package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemMapper;
import com.java.dto.MemDto;

@Service
public class MServiceImpl implements MService {

	@Autowired
	MemMapper memMapper;

	@Override
	public ArrayList<MemDto> mlist() {
		
		ArrayList<MemDto> list = new ArrayList<>();
		list = memMapper.mlist();
		return list;
	}
}
