package com.java.phone;

public class PhoneApp {

	public static void main(String[] args) {
		InitPhoneBook init = new InitPhoneBook();
		Show addressBook = new Show();
		
		init.initPhoneBook();
		addressBook.show();
	}
}
