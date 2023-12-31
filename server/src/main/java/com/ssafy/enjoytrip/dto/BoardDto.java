package com.ssafy.enjoytrip.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {

	private int articleNo;
	private String userId;
	private String subject;
	private String content;
	private int hit;
	private String registerTime;

}
