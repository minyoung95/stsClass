package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.EMapper;
import com.java.dto.CboardDto;
import com.java.dto.EventDto;

@Transactional // 두개 중 하나가 에러가 났을때 원상복구
@Service
public class EServiceImpl implements EService {

	@Autowired EMapper eMapper;
	
	@Override
	public ArrayList<EventDto> event() {
		
		ArrayList<EventDto> list = eMapper.selectAll();
		return list;
	}

	@Override
	public EventDto eview(int eno) {
		
		EventDto eventDto = eMapper.selectOne(eno);
		return eventDto;
	}

	@Override
	public ArrayList<CboardDto> clist(int eno) {
		
		ArrayList<CboardDto> clist = eMapper.selectAllCboard(eno);
		return clist;
	}

	@Override
	public CboardDto cwrite(CboardDto cdto) {
		
		eMapper.insertCboard(cdto);
		CboardDto cboardDto = eMapper.selectOneCboard(cdto.getCno()); // 새로고침 없이 바로 업데이트 될 수 있게
		return cboardDto;
	}

	@Override
	public CboardDto cupdate(CboardDto cdto) {
		
		eMapper.updateCboard(cdto);
		CboardDto cboardDto = eMapper.selectOneCboard(cdto.getCno());
		return cboardDto;
	}

	@Override
	public void cdelete(int cno) {
		
		eMapper.deleteCboard(cno);
	}


}
