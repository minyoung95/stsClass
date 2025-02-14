package com.java.service;

import java.util.ArrayList;

import com.java.dto.EventDto;

public interface EService {

	ArrayList<EventDto> elist();

	EventDto eview(int eno);

}
