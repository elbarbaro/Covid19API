package com.clubprogramacionbarbaro.covidapi.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException {
	
	public UnauthorizedException() {
		super("Credenciales no validas");
	}
}
