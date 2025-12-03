package com.example.demo.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorInfo implements Serializable {
	public ActorInfo(int i, String string, String string2) {
		this.actorId = i ; 
		this.actorName = string ; 
		this.actorAddrs = string2 ; 
	}
	private Integer actorId;
    private String actorName;
    private String actorAddrs;
}
