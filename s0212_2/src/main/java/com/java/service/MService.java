package com.java.service;

import com.java.dto.MemberDto;

public interface MService {

	MemberDto login(MemberDto mdto);

	String sendEmail(String email);

	String sendEmail2(String email);
}
