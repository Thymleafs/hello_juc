package com.atguigu.juc.thread;

public enum CountryEnum {

	ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"赵"),FIVE(5,"韩"),SIX(6,"魏");
	private int code;
	private String name;
	
	
	private CountryEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static CountryEnum forEach_Country(int i) {
		CountryEnum[] enums = CountryEnum.values();
		return enums[i-1];
	}
	
}
