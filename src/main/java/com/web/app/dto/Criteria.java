package com.web.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	int pageNum;
	int amount;
	public Criteria() {
		this.pageNum = 1;
		this.amount = 10;
	}
	public Criteria(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	
}
