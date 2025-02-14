package com.java.dao;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemberDto;

@Mapper
public interface MMapper {

	MemberDto selectLogin(MemberDto mdto);

}
