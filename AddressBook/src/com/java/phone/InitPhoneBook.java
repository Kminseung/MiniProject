package com.java.phone;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class InitPhoneBook {
	static final String rootPath = System.getProperty("user.dir");
	static final String filename = rootPath + "\\addressBook.txt";
	private static List<Phone> phone = new ArrayList<Phone>();
	
	// 초깃값 지정
	private String[] s = { "고길동,010-10**-23**,02-43**-90**\n",
			"도우너,010-55**-55**,02-43**-90**\n",
			"마이콜,010-99**-77**,02-43**-90**\n",
			"또치,010-88**-90**,02-43**-90**\n",
			"강민승,010-55**-65**,032-2**-65**\n" };

	public static List<Phone> getPhone() {
		return phone;
	}
	
	public void init(String s) {
		String[] ss = s.split(",");
		phone.add(new Phone(ss[0], ss[1], ss[2].trim()));
	}
	
	public void initPhoneBook() {
		File f = new File(filename);		// 파일 생성
		Writer writer = null;
		
		try {
			writer = new FileWriter(f);
			
			for(int i=0; i<s.length; i++) {
				init(s[i]);
				writer.write(s[i]);
			}
			
			//내부 버퍼 비우기
			writer.flush();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				writer.close();
			}
			catch(Exception e) {
				
			}
		}
	}
}
