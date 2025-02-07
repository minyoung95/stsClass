package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MemDto {

	private String id;
	private String pw;
	private String name;
	private String tel;
	private String gender;
	private String hobby;
	private String[] hobbys;
	
}
