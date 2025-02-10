package com.java.service;

import java.util.ArrayList;

import com.java.dto.Board;

public interface BoardService {

	ArrayList<Board> blist();

	void bwrite(Board bdto);

}
