package com.sharebo.entity;
/**
 * 返回参数
 * @author niewei
 */
public class ResultInfo {
	private Integer code;
	private String msg;
	private Object result;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public ResultInfo(Integer code, String msg, Object result) {
		super();
		this.code = code;
		this.msg = msg;
		this.result = result;
	}
	public ResultInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResultInfo(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
}
