package com.kh.spring.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AjaxResponse {
	private String Code;
	private String message;
	private Object data;
	
}
