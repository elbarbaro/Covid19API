package com.clubprogramacionbarbaro.covidapi.error;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	//@ExceptionHandler(UnauthorizedException.class)
	public void handleNotFoudException(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	}
	
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<Object> handleUnauthorizedException(Exception exception) {
		
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("status", HttpStatus.UNAUTHORIZED);
		body.put("error", exception.getMessage());
		body.put("message", "");
		
		return new ResponseEntity<Object>(body, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		System.out.println("Entro");
		Map<String, Object> body = new LinkedHashMap<>();
		
		body.put("timestamp", new Date());
		body.put("status", status.value());
		body.put("error", status.getReasonPhrase());
		body.put("message", ex.getBindingResult().getFieldError().getDefaultMessage());
	
		return new ResponseEntity<Object>(body, headers, status);
	}
	
}
