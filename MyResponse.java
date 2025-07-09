package com.vishal.demo;

public class MyResponse<T> {
	T t;
	String message;
	
	
	public MyResponse(T t, String message) {
		super();
		this.t = t;
		this.message = message;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
