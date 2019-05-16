package test.boot.common.advice;

public class BusinessException extends Exception{
	private String errMessage;
	public BusinessException(String errMsg){
		this.errMessage = errMsg;
	}
	public String getErrMessage() {
		return errMessage;
	}
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	
	
	
}
