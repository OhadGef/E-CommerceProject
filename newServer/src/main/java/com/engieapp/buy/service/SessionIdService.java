package com.engieapp.buy.service;

import java.util.UUID;

import javax.persistence.Entity;

import org.springframework.stereotype.Service;

@Service
public class SessionIdService {
	
	private String uId ;
	
	
	public SessionIdService() {
		this.uId =  UUID.randomUUID().toString().replace("-", "");
		}
	public String getuId() {
		return uId;
	}

	
	
}
