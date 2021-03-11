package com.java.phone;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class InitPhoneBook {
	static final String rootPath = System.getProperty("user.dir");
	static final String filename = rootPath + "\\addressBook.txt";
	
	
	public void initPhoneBook() {
		File f = new File(filename);		// 파일 생성
		Writer writer = null;
		
		// 초깃값 지정
		String s1 = "고길동,010-10**-23**,02-43**-90**\n";
		String s2 = "도우너,010-55**-55**,02-43**-90**\n";
		String s3 = "마이콜,010-99**-77**,02-43**-90**\n";
		String s4 = "또치,010-88**-90**,02-43**-90**\n";
		String s5 = "강민승,010-55**-65**,032-2**-65**\n";
		
		try {
			writer = new FileWriter(f);
			
			writer.write(s1);
			writer.write(s2);
			writer.write(s3);
			writer.write(s4);
			writer.write(s5);
			
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
