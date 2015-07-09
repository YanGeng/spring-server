package com.amos.service;

import java.util.Date;

public class HelloImpl implements IHello {

	private String msg;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	//@Override
	public String sayHi() {
		// TODO Auto-generated method stub
		return "当前时间: "+ new Date() + " msg: " + msg;
	}

}
