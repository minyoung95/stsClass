package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BService {

	ArrayList<BoardDto> blist();

	void bwrite(BoardDto bdto);

	BoardDto bview(int bno);

}
