package com.java.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.dto.BoardDto;

public interface CService {

	Map<String, Object> notice(int page);

	BoardDto nview(int bno);

}
