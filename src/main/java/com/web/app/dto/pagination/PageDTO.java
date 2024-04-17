package com.web.app.dto.pagination;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	private int startPage;
	private int endPage;
	
	private boolean prev;
	private boolean next;
	
	private Criteria criteria;
	private long total;
	
	public PageDTO(Criteria criteria, long total) {
		super();
		this.criteria = criteria;
		this.total = total;
		
		this.endPage = (int)( Math.ceil(criteria.getPageNum() / (double)criteria.getAmount()) ) * 10;
		this.startPage = endPage - 9;
		this.prev = this.startPage > 1;
		 
		int realEnd = (int)( Math.ceil(total*1.0 / criteria.getAmount()) );
		
		this.endPage = this.endPage >= realEnd ? realEnd : endPage;
		
		this.next = this.endPage < realEnd;
	}
	
	
}
