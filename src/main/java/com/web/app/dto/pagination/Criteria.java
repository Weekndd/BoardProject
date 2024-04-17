package com.web.app.dto.pagination;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum;
	private int amount;
	
	private String type;
	private String keyword;
	
	public Criteria() {
		this.pageNum = 1;
		this.amount = 10;
	}
	public Criteria(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}

	//마이바티스는 getter, setter로 동작해서 
	//Collection = "typeArr"부분에서 확인 후 getTypeArr을 실행시킴
	public String[] getTypeArr() {
		return type == null? new String[] {} : type.split("");
	}
	
}
