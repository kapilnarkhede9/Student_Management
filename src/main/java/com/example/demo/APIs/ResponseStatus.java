package com.example.demo.APIs;

public class ResponseStatus {
	private int status = 200;
	private String message = "No Exception Found";
	private String type = "All is well";
	private String dev_hint = message;
	private StackTraceElement[] stackTrace; 
	public ResponseStatus() {
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public String getDev_hint() {
		return dev_hint;
	}

	public void setDev_hint(String dev_hint) {
		this.dev_hint = dev_hint;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setStackTrace(StackTraceElement[] stackTrace1) {
		this.stackTrace = stackTrace1;
	}

	public int getStatus() {
		return status;
	}

	public ResponseStatus(int status,StackTraceElement[] stacktrace, String message, String type, String dev_hint) {
		super();
		this.stackTrace=stacktrace;
		this.status = status;
		this.message = message;
		this.type = type;
		this.dev_hint = dev_hint;
	}
	public ResponseStatus(int status,StackTraceElement[] stackTrace, String message, String type) {
		super();
		this.stackTrace=stackTrace;
		this.status = status;
		this.message = message;
		this.type = type;
		this.dev_hint =message;
	}

	public StackTraceElement[] getStackTrace() {
		return stackTrace;
	}


	public void setMessage(String message) {
		this.message = message;
	}

}
