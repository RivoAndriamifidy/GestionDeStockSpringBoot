package com.rivo.gestiondestock.handler;

import java.util.ArrayList;
import java.util.List;

import com.rivo.gestiondestock.exception.ErrorCodes;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorDto {

	private Integer httpCode;
	
	private ErrorCodes code;
	
	private String message;
	
	private List<String> errors = new ArrayList<>();
}
