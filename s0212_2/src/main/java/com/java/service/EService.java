package com.java.service;

import java.util.ArrayList;

import com.java.dto.CboardDto;
import com.java.dto.EventDto;

public interface EService {

	ArrayList<EventDto> event();

	EventDto eview(int eno);

	ArrayList<CboardDto> clist(int eno);

	CboardDto cwrite(CboardDto cdto);

	CboardDto cupdate(CboardDto cdto);

	void cdelete(int cno);

}
