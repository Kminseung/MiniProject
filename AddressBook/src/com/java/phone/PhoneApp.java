package com.java.phone;

public class PhoneApp {

	public static void main(String[] args) {
		Show addressBook = new Show();
		InitPhoneBook init = new InitPhoneBook();
		
		init.initPhoneBook();
		addressBook.show();
	}

}
