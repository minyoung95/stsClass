package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.EMapper;
import com.java.dto.EventDto;

@Service
public class EServiceImpl implements EService {

	@Autowired EMapper eMapper;
	
	@Override
	public ArrayList<EventDto> elist() {
		
		ArrayList<EventDto> list = eMapper.selectAll();
		return list;
	}

	@Override
	public EventDto eview(int eno) {
		EventDto eventDto = eMapper.selectOne(eno);
		return eventDto;
	}
}
