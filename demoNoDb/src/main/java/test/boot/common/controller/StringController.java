package test.boot.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.boot.common.object.ObjectParam;
import test.boot.common.object.ResponseStatus;

@RestController
@RequestMapping("/api")
public class StringController extends AbstractPassThroughController<ObjectParam, ResponseStatus>{
	 private static final Logger logger = LoggerFactory.getLogger(StringController.class);
	 
	 
	@Override
	protected ObjectParam transformParam(HttpServletRequest servletRequest) {
		// TODO Auto-generated method stub
		ObjectParam obPa = new ObjectParam();
		obPa.setName(servletRequest.getParameter("name"));
		obPa.setAddress(servletRequest.getParameter("address"));
		return obPa;
	}

	@Override
	protected void validate(ObjectParam request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ResponseEntity<ResponseStatus> execute(ObjectParam request) {
		// TODO Auto-generated method stub
		ResponseStatus res =new ResponseStatus();
		res.setMessage("success");
		res.setStatus(true);
		 return new ResponseEntity<ResponseStatus>(res,HttpStatus.OK);
	}

	@Override
	@RequestMapping(value="/testMessage", method = RequestMethod.POST, produces = "application/json")
	protected ResponseEntity<ResponseStatus> buildResponse(HttpServletRequest servletRequest) {
		// TODO Auto-generated method stub
		ObjectParam reqParam = this.transformParam(servletRequest);
		ResponseEntity<ResponseStatus> response = getResponseEntity(reqParam);
		return response;
	}

}
