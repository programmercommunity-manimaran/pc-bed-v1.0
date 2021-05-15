package com.programmer.community.user.model;

public class Response {
	private int code;
	private String messge;

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessge() {
		return this.messge;
	}

	public void setMessge(String messge) {
		this.messge = messge;
	}

	public Response(int code, String messge) {
		super();
		this.code = code;
		this.messge = messge;
	}

	public Response() {
		super();
	}

	public static Response getSuccess() {
		return new Response(200, "Success");
	}

	public static Response getExists() {
		return new Response(409, "Exists");
	}

	public static Response getNotFound() {
		return new Response(204, "Not Found");
	}
}
