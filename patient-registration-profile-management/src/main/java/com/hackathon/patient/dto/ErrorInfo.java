package com.hackathon.patient.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ErrorInfo {
	LocalDateTime timestamp;
	String msg;
	public ErrorInfo(LocalDateTime timestamp, String msg) {
		super();
		this.timestamp = timestamp;
		this.msg = msg;
	}
	public ErrorInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "ErrorInfo [timestamp=" + timestamp + ", msg=" + msg + "]";
	}

}
