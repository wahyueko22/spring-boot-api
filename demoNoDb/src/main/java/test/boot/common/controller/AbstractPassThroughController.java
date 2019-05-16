package test.boot.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

public abstract class AbstractPassThroughController<Request, Response> {
	
	protected abstract Request transformParam(HttpServletRequest servletRequest);
	protected abstract void validate(Request request);
	protected abstract ResponseEntity<Response> execute(Request request);
	protected abstract ResponseEntity<Response> buildResponse(HttpServletRequest servletRequest);
	
	protected ResponseEntity<Response> getResponseEntity(Request request) {
    	validate(request);
    	ResponseEntity<Response> entity = execute(request);
		return entity;
    }

}
