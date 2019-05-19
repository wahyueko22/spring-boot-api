package test.boot.common.object;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseStatus {
	@JsonProperty("status")
	private Boolean status;
	@JsonProperty("message")
	private String message;
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
