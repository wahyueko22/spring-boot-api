package test.boot.common.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import test.boot.DemoApplication;

@ControllerAdvice
public class PaymentResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(PaymentResponseEntityExceptionHandler.class);
	
	@ExceptionHandler({TestException.class})
	protected ResponseEntity<Object> handleInvalidRequest(TestException ex, WebRequest request) {
		TestException ire = (TestException) ex;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		logger.error(ex.getMessage(),ex);
		
		ErrorResponse error = new ErrorResponse();
		error.setSuccess(false);
		error.setErrorMsg(ire.getMessage());
		error.setErrorCd("CODE_01");
		
		//logger.warn("InvalidRequestException {}", ire.getMessage());
		return new ResponseEntity<Object>(error, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);

	}
	
	@ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> businessExcpetionHandler(BusinessException ex, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		logger.error(ex.getErrMessage(),ex);
		
		
		ErrorResponse error = new ErrorResponse();
		error.setSuccess(false);
		if (ex.getErrMessage() != null){
			String errArr[] = ex.getErrMessage().split("\\|");
			if(errArr.length > 1){
				error.setErrorCd(errArr[0]);
				error.setErrorMsg(errArr[1]);
			}
			else {
				error.setErrorMsg(ex.getErrMessage());
				error.setErrorCd("ERR_BUS_01");
			}
		}
        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		logger.error(ex.getMessage(),ex);
		
		ErrorResponse error = new ErrorResponse();
		error.setSuccess(false);
		error.setErrorMsg(ex.getMessage());
		error.setErrorCd("CODE_03");
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
}
