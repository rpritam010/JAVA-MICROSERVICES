package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("SomeBeanFilter")
public class SomeBean {
	
	private String Fields1;
	
	private String Fields2;
	
	
	private String Fields3;

	public SomeBean(String fields1, String fields2, String fields3) {
		super();
		Fields1 = fields1;
		Fields2 = fields2;
		Fields3 = fields3;
	}

	public String getFields1() {
		return Fields1;
	}

	public void setFields1(String fields1) {
		Fields1 = fields1;
	}

	public String getFields2() {
		return Fields2;
	}

	public void setFields2(String fields2) {
		Fields2 = fields2;
	}

	public String getFields3() {
		return Fields3;
	}

	public void setFields3(String fields3) {
		Fields3 = fields3;
	}
	
	

}
