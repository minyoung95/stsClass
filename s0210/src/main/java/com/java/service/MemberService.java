package com.java.service;

import com.java.dto.Member;

public interface MemberService {

	Member login(String id, String pw);

	void member(Member mdto);

}
