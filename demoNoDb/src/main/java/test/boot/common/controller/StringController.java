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

@RestController
@RequestMapping("/api")
public class StringController extends AbstractPassThroughController<ObjectParam, String>{
	 private static final Logger logger = LoggerFactory.getLogger(StringController.class);
	 @Value("${prop.env.data}")
	 private String envData;
	// @Value("${mail.name}")
	 private String mailName;
	 
	@Override
	protected ObjectParam transformParam(HttpServletRequest servletRequest) {
		// TODO Auto-generated method stub
		ObjectParam obPa = new ObjectParam();
		obPa.setName(servletRequest.getParameter("name"));
		obPa.setAddress(servletRequest.getParameter("address"));
		logger.info("masukk bosss {} ===", envData);
		return obPa;
	}

	@Override
	protected void validate(ObjectParam request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ResponseEntity<String> execute(ObjectParam request) {
		// TODO Auto-generated method stub
		 return new ResponseEntity<String>("berhasil",HttpStatus.OK);
	}

	@Override
	@RequestMapping(value="/testMessage", method = RequestMethod.POST, produces = "application/json")
	protected ResponseEntity<String> buildResponse(HttpServletRequest servletRequest) {
		// TODO Auto-generated method stub
		ObjectParam reqParam = this.transformParam(servletRequest);
		ResponseEntity<String> response = getResponseEntity(reqParam);
		return response;
	}

}
