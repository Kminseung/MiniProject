package com.java.phone;

public class Phone {
	private String name;		// 이름
	private String hp;			// 휴대전화
	private String tel;			// 집전화
	
	// default generator
	public Phone() { }
	
	// generator
	public Phone(String name, String hp, String tel) {
		this.name = name;
		this.hp = hp;
		this.tel = tel;
	}

	// getter
	public String getName() {
		return name;
	}

	public String getHp() {
		return hp;
	}

	public String getTel() {
		return tel;
	}
	
}
