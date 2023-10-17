package com.empresa.app.util;

public class ApiResponse<T> {
	
	private boolean success;
    private T data;
    private String message;
    
    public ApiResponse(boolean success, T data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public ApiResponse(boolean success, T data) {
        this.success = success;
        this.data = data;
        this.message = success ? "Operación exitosa" : "Operación fallida";
    }

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}   
}
